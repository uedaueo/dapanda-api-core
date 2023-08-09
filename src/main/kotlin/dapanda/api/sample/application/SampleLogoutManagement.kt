package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.application.ApiBase
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.random.IDapandaRandomFactory
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
    private val apiBasePlain: ApiBasePlain,
    private val loginRepository: ISampleLoginRepository
) : IApiBasePlain by apiBasePlain {
    fun doPut(
        httpRequest: HttpCommonRequest<SampleLogoutPutRequest>
    ): HttpResponse<SampleLogoutPutResponse> {
        val telegram = httpRequest.commonRequest!!

        loginRepository.deleteToken(telegram.userId)

        return HttpResponse.ok()
    }
}
