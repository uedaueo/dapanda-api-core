package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.application.ApiBase
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.sample.blanco.SampleRegisterPostRequest
import dapanda.api.sample.blanco.SampleRegisterPostResponse
import dapanda.api.sample.domain.register.ISampleRegisterRepository
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.sql.SQLIntegrityConstraintViolationException

/**
 * ユーザー登録登録を行います。
 */
@Singleton
class SampleRegisterManagement (
    private val apiBase: ApiBase,
    private val registerRepository: ISampleRegisterRepository,
    private val localeResolver: LocaleResolver,
    private val resourceBundle: CommonResourceBundleFactory,
    @Value("\${token-authenticate.salt}")
    private val salt: String
) : IApiBase by apiBase {
    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleRegisterPostRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, SampleRegisterPostResponse>> {
        val telegram = httpRequest.commonRequest!!.telegram!!
        val locale = localeResolver.resolve(httpRequest)
        runCatching {
            registerRepository.add(telegram.userId, telegram.password.sha256WithSalt(salt))
        }.onFailure {
            if(it.cause is SQLIntegrityConstraintViolationException) {
                val metaInfo = ApiResponseMetaInfoConstants.META90002
                metaInfo.message = resourceBundle.getApiResultMessage(locale).arm90002
                val logMessage = resourceBundle.getApiLogMessage(locale).alm90002
                throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
            }
        }

        return HttpResponse.ok()
    }
}