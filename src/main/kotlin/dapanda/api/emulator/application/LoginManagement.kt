package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.CommonConst
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.ErrorLogMessage
import dapanda.api.common.domain.model.ErrorResponseMessage
import dapanda.api.common.domain.model.exceptions.DapandaRuntimeException
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.core.blanco.db.common.exception.NoRowFoundException
import dapanda.api.emulator.blanco.LoginPostRequest
import dapanda.api.emulator.blanco.LoginPostResponse
import dapanda.api.emulator.domain.Const
import dapanda.api.emulator.domain.login.ILoginQuery
import dapanda.api.emulator.domain.login.ILoginRepository
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.util.*
import javax.sql.DataSource

/**
 * ログイン処理を行います。
 */
@Singleton
class LoginManagement (
    private val apiBase: ApiBase,
    private val dataSource: DataSource,
    private val loginQuery: ILoginQuery,
    private val loginRepository: ILoginRepository
) : IApiBase by apiBase {
    companion object {
        private val log by LoggerDelegate()
    }

    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, LoginPostRequest>>
    ): HttpResponse<CommonResponse<LoginPostResponse>> {
        val telegram: LoginPostRequest = httpRequest.commonRequest!!.telegram!!
        val password = getPassword(telegram.userId)
        if ((password == null) || !verifyPassword(password, telegram.password)) {
            if (password == null) {
                log.error(ErrorLogMessage.valueRetrievedFromDatabaseIsNull)
            }
            throw DapandaRuntimeException(
                message = ErrorResponseMessage.notVerifyPassword
            )
        }

        val token = generateToken()
        val validTerm = validTokenTime()

        dataSource.connection.use { connection ->
            loginRepository.deleteToken(telegram.userId)
            loginRepository.addToken(telegram.userId, token, validTerm)
            connection.commit()
        }

        return HttpResponse.ok(
            CommonResponse(
                telegram = LoginPostResponse(token)
            )
        )
    }

    private fun verifyPassword(tablePassword: String, requestPassword: String): Boolean {
        return requestPassword.sha256WithSalt(CommonConst.PASSWORD_SALT) == tablePassword
    }

    /**
     * トークン有効期間
     *
     * @return 現在時刻＋有効期間でトークン有効期限
     */
    private fun validTokenTime(): Long {
        return Calendar.getInstance().run {
            add(Calendar.MINUTE, CommonConst.LOGIN_TOKEN_VALID_TERM)
            timeInMillis/CommonConst.RATIO_MILLISECOND_TO_SECOND
        }
    }

    private fun getPassword(userId: String): String? {
        return runCatching {
            loginQuery.findUser(userId)?.password
        }
            .onFailure {
                if (it is NoRowFoundException) {
                    throw DapandaRuntimeException(
                        message = ErrorResponseMessage.notFoundUserId,
                        cause = it
                    )
                } else {
                    throw it
                }
            }
            .getOrElse {
                throw it
            }
    }

    private fun generateToken(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }
}