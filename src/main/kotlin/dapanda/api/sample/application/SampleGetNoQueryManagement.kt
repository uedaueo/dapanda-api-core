package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.application.ApiBase
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.http.*
import dapanda.api.sample.blanco.SampleGetNoQueryGetRequest
import dapanda.api.sample.blanco.SampleGetNoQueryGetResponse
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleGetNoQueryManagement (private val apiBasePlain: ApiBasePlain) : IApiBasePlain by apiBasePlain {

    fun doGet(httpCommonRequest: HttpCommonRequest<SampleGetNoQueryGetRequest>): HttpResponse<SampleGetNoQueryGetResponse> {
        val responseTelegram = SampleGetNoQueryGetResponse()

        return CommonHttpResponseFactory.create(responseTelegram)
    }
}
