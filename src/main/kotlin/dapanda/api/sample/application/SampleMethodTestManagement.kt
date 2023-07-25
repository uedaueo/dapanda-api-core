package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.CommonHttpResponsePlainFactory
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.sample.blanco.*
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleMethodTestManagement(
    private val apiBasePlain: ApiBasePlain,
    ) : IApiBasePlain by apiBasePlain {

    fun doGet(httpCommonRequest: HttpCommonRequest<SampleMethodTestGetRequest>): HttpResponse<SampleMethodTestGetResponse> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestGetResponse()

        return CommonHttpResponsePlainFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doPost(httpCommonRequest: HttpCommonRequest<SampleMethodTestPostRequest>): HttpResponse<SampleMethodTestPostResponse> {
        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestPostResponse()

        return CommonHttpResponsePlainFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doPut(httpCommonRequest: HttpCommonRequest<SampleMethodTestPutRequest>): HttpResponse<SampleMethodTestPutResponse> {

        val responseTelegram = SampleMethodTestPutResponse()

        return CommonHttpResponsePlainFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doDelete(httpCommonRequest: HttpCommonRequest<SampleMethodTestDeleteRequest>): HttpResponse<SampleMethodTestDeleteResponse> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestDeleteResponse()

        return CommonHttpResponsePlainFactory.create(
            responseTelegram, httpCommonRequest
        )
    }
}
