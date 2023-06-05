package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.http.getStartTime
import dapanda.api.sample.blanco.*
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleMethodTestManagement(
    private val apiBase: ApiBase,
    ) : IApiBase by apiBase {

    fun doGet(httpCommonRequest: HttpCommonRequest<SampleMethodTestGetRequest>): HttpResponse<SampleMethodTestGetResponse> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestGetResponse()

        return CommonHttpResponseFactory.create(
            responseTelegram
        )
    }

    fun doPost(httpCommonRequest: HttpCommonRequest<SampleMethodTestPostRequest>): HttpResponse<SampleMethodTestPostResponse> {
        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestPostResponse()

        return CommonHttpResponseFactory.create(
            responseTelegram
        )
    }

    fun doPut(httpCommonRequest: HttpCommonRequest<SampleMethodTestPutRequest>): HttpResponse<SampleMethodTestPutResponse> {

        val responseTelegram = SampleMethodTestPutResponse()

        return CommonHttpResponseFactory.create(
            responseTelegram
        )
    }

    fun doDelete(httpCommonRequest: HttpCommonRequest<SampleMethodTestDeleteRequest>): HttpResponse<SampleMethodTestDeleteResponse> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestDeleteResponse()

        return CommonHttpResponseFactory.create(
            responseTelegram
        )
    }
}
