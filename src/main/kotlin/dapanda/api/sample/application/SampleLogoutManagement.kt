package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.sample.blanco.SampleLogoutPutRequest
import dapanda.api.sample.blanco.SampleLogoutPutResponse
import dapanda.api.sample.domain.login.ISampleLoginRepository
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

/**
 * ログアウト処理を行います。
 */
@Singleton
class SampleLogoutManagement (
    private val apiBase: ApiBase,
    private val loginRepository: ISampleLoginRepository
) : IApiBase by apiBase {
    fun doPut(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleLogoutPutRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, SampleLogoutPutResponse>> {
        val telegram = httpRequest.commonRequest!!.telegram!!

        loginRepository.deleteToken(telegram.userId)

        return HttpResponse.ok()
    }
}