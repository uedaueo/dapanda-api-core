package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.application.ApiBase
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.core.blanco.db.common.exception.NoRowFoundException
import dapanda.api.emulator.blanco.LoginPostRequest
import dapanda.api.emulator.blanco.LoginPostResponse
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
    private val loginRepository: ILoginRepository,
    private val localeResolver: LocaleResolver,
    private val resourceBundle: CommonResourceBundleFactory
) : IApiBase by apiBase {
    companion object {
        private val log by LoggerDelegate()
    }

    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, LoginPostRequest>>
    ): HttpResponse<CommonResponse<LoginPostResponse>> {
        val locale = localeResolver.resolve(httpRequest)
        val telegram: LoginPostRequest = httpRequest.commonRequest!!.telegram!!
        val password = getPassword(telegram.userId, locale)
        if ((password == null) || !verifyPassword(password, telegram.password)) {
            var logMessage = ""

            if (password == null) {
                logMessage = resourceBundle.getApiLogMessage(locale).alm004
            }
            val metaInfo = ApiResponseMetaInfoConstants.META004
            metaInfo.message = resourceBundle.getApiResultMessage(locale).arm004
            throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
        }

        val token = generateToken()
        val validTerm = validTokenTime()

        dataSource.connection.use { connection ->
            loginRepository.deleteToken(telegram.userId)
            loginRepository.addToken(telegram.userId, token, validTerm)
            connection.commit()
        }

        val responseTelegram = LoginPostResponse(token)

        return CommonHttpResponseFactory.create(
            responseTelegram
        )
    }

    private fun verifyPassword(tablePassword: String, requestPassword: String): Boolean {
        return requestPassword.sha256WithSalt(CommonConstants.PASSWORD_SALT) == tablePassword
    }

    /**
     * トークン有効期間
     *
     * @return 現在時刻＋有効期間でトークン有効期限
     */
    private fun validTokenTime(): Long {
        return Calendar.getInstance().run {
            add(Calendar.MINUTE, CommonConstants.LOGIN_TOKEN_VALID_TERM)
            timeInMillis/ CommonConstants.RATIO_MILLISECOND_TO_SECOND
        }
    }

    private fun getPassword(userId: String, locale: Locale): String? {
        return runCatching {
            loginQuery.findUser(userId)?.password
        }
            .onFailure {
                if (it is NoRowFoundException) {
                    val metaInfo = ApiResponseMetaInfoConstants.META003
                    metaInfo.message = resourceBundle.getApiResultMessage(locale).arm003
                    val logMessage = resourceBundle.getApiLogMessage(locale).alm003
                    throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
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