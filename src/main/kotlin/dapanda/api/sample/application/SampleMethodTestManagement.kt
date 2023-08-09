package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.PlainHttpResponseFactory
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.random.IDapandaRandomFactory
import dapanda.api.sample.blanco.*
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleMethodTestManagement(
    private val apiBasePlain: ApiBasePlain,
    private val randomFactory: IDapandaRandomFactory
) : IApiBasePlain by apiBasePlain {

    companion object {
        private val log by LoggerDelegate()
    }

    fun doGet(httpCommonRequest: HttpCommonRequest<SampleMethodTestGetRequest>): HttpResponse<SampleMethodTestGetResponse> {

        val rand = randomFactory.getSecureRandom()
        log.debug("%%% rand = " + rand.algorithm)

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestGetResponse()

        return PlainHttpResponseFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doPost(httpCommonRequest: HttpCommonRequest<SampleMethodTestPostRequest>): HttpResponse<SampleMethodTestPostResponse> {
        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestPostResponse()

        return PlainHttpResponseFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doPut(httpCommonRequest: HttpCommonRequest<SampleMethodTestPutRequest>): HttpResponse<SampleMethodTestPutResponse> {

        val responseTelegram = SampleMethodTestPutResponse()

        return PlainHttpResponseFactory.create(
            responseTelegram, httpCommonRequest
        )
    }

    fun doDelete(httpCommonRequest: HttpCommonRequest<SampleMethodTestDeleteRequest>): HttpResponse<SampleMethodTestDeleteResponse> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        val responseTelegram = SampleMethodTestDeleteResponse()

        return PlainHttpResponseFactory.create(
            responseTelegram, httpCommonRequest
        )
    }
}
