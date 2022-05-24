package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.emulator.blanco.LogoutPutRequest
import dapanda.api.emulator.blanco.LogoutPutResponse
import dapanda.api.emulator.domain.login.ILoginRepository
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

/**
 * ログアウト処理を行います。
 */
@Singleton
class LogoutManagement (
    private val apiBase: ApiBase,
    private val loginRepository: ILoginRepository
) : IApiBase by apiBase {
    fun doPut(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, LogoutPutRequest>>
    ): HttpResponse<CommonResponse<LogoutPutResponse>> {
        val telegram: LogoutPutRequest = httpRequest.commonRequest!!.telegram!!

        loginRepository.deleteToken(telegram.userId)

        return HttpResponse.ok()
    }
}