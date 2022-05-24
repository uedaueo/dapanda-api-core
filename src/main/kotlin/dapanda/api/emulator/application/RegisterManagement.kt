package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.CommonConst
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.ErrorResponseMessage
import dapanda.api.common.domain.model.exceptions.DapandaRuntimeException
import dapanda.api.common.domain.model.hashing.sha256WithSalt
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.emulator.blanco.RegisterPostRequest
import dapanda.api.emulator.blanco.RegisterPostResponse
import dapanda.api.emulator.domain.Const
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
    private val registerRepository: IRegisterRepository
) : IApiBase by apiBase {
    fun doPost(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, RegisterPostRequest>>
    ): HttpResponse<CommonResponse<RegisterPostResponse>> {
        val telegram: RegisterPostRequest = httpRequest.commonRequest!!.telegram!!

        runCatching {
            registerRepository.add(telegram.userId, telegram.password.sha256WithSalt(CommonConst.PASSWORD_SALT))
        }.onFailure {
            if(it.cause is SQLIntegrityConstraintViolationException) {
                throw DapandaRuntimeException(
                    message = ErrorResponseMessage.duplicateUserId,
                    cause = it
                )
            }
        }

        return HttpResponse.ok()
    }
}