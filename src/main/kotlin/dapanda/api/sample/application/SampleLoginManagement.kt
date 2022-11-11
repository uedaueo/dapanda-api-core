package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.application.ApiBase
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.http.getStartTime
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.core.blanco.db.common.exception.NoRowFoundException
import dapanda.api.sample.blanco.SampleLoginPostRequest
import dapanda.api.sample.blanco.SampleLoginPostResponse
import dapanda.api.sample.domain.login.ISampleLoginQuery
import dapanda.api.sample.domain.login.ISampleLoginRepository
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.util.*
import java.util.Locale
import javax.sql.DataSource

/**
 * ログイン処理を行います。
 */
@Singleton
class SampleLoginManagement (
    private val apiBase: ApiBase,
    private val dataSource: DataSource,
    private val loginQuery: ISampleLoginQuery,
    private val loginRepository: ISampleLoginRepository,
    private val localeResolver: LocaleResolver,
    private val resourceBundle: CommonResourceBundleFactory,
    @Value("\${token-authenticate.token-valid-term}")
    private val tokenValidTerm: Int,
    @Value("\${token-authenticate.salt}")
    private val salt: String,
    @Value("\${spoil.SampleLogin.POST}")
    private val spoilSampleLoginPost: Boolean
    ) : IApiBase by apiBase {
    companion object {
        private val log by LoggerDelegate()
    }

    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleLoginPostRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, SampleLoginPostResponse>> {
        val locale = localeResolver.resolve(httpRequest)
        val telegram = httpRequest.commonRequest!!.telegram!!
        val password = getPassword(telegram.userId, locale)
        if ((password == null) || !verifyPassword(password, telegram.password)) {
            var logMessage = ""

            if (password == null) {
                logMessage = resourceBundle.getApiLogMessage(locale).alm90004
            }
            val metaInfo = ApiResponseMetaInfoConstants.META90004
            metaInfo.message = resourceBundle.getApiResultMessage(locale).arm90004
            throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
        }

        val token = generateToken()
        val validTerm = validTokenTime()

        dataSource.connection.use { connection ->
            loginRepository.deleteToken(telegram.userId)
            loginRepository.addToken(telegram.userId, token, validTerm)
            connection.commit()
        }

        val responseTelegram = SampleLoginPostResponse(token)
        var responseLocale = blanco.restgenerator.valueobject.Locale()
            httpRequest.commonRequest?.let {
                responseLocale = it.info.locale
            }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }

    private fun verifyPassword(tablePassword: String, requestPassword: String): Boolean {
        return requestPassword.sha256WithSalt(salt) == tablePassword
    }

    /**
     * トークン有効期間
     *
     * @return 現在時刻＋有効期間でトークン有効期限
     */
    private fun validTokenTime(): Long {
        return Calendar.getInstance().run {
            add(Calendar.MINUTE, tokenValidTerm)
            timeInMillis/ CommonConstants.RATIO_MILLISECOND_TO_SECOND
        }
    }

    private fun getPassword(userId: String, locale: Locale): String? {
        return runCatching {
            loginQuery.findUser(userId)?.password
        }
            .onFailure {
                if (it is NoRowFoundException) {
                    val metaInfo = ApiResponseMetaInfoConstants.META90003
                    metaInfo.message = resourceBundle.getApiResultMessage(locale).arm90003
                    val logMessage = resourceBundle.getApiLogMessage(locale).alm90003
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

    override fun isSpoiled(method: String): Boolean {
        var result = false
        if (method == CommonConstants.HTTP_POST) {
            result = spoilSampleLoginPost
        }

        return result
    }
}