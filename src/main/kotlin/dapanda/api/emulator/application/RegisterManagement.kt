package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.application.ApiBase
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.exceptions.ApiRuntimeException
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.emulator.blanco.RegisterPostRequest
import dapanda.api.emulator.blanco.RegisterPostResponse
import dapanda.api.emulator.domain.register.IRegisterRepository
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.sql.SQLIntegrityConstraintViolationException

/**
 * ユーザー登録登録を行います。
 */
@Singleton
class RegisterManagement (
    private val apiBase: ApiBase,
    private val registerRepository: IRegisterRepository,
    private val localeResolver: LocaleResolver,
    private val resourceBundle: CommonResourceBundleFactory
) : IApiBase by apiBase {
    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, RegisterPostRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, RegisterPostResponse>> {
        val telegram: RegisterPostRequest = httpRequest.commonRequest!!.telegram!!
        val locale = localeResolver.resolve(httpRequest)
        runCatching {
            registerRepository.add(telegram.userId, telegram.password.sha256WithSalt(CommonConstants.PASSWORD_SALT))
        }.onFailure {
            if(it.cause is SQLIntegrityConstraintViolationException) {
                val metaInfo = ApiResponseMetaInfoConstants.META002
                metaInfo.message = resourceBundle.getApiResultMessage(locale).arm002
                val logMessage = resourceBundle.getApiLogMessage(locale).alm002
                throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
            }
        }

        return HttpResponse.ok()
    }
}