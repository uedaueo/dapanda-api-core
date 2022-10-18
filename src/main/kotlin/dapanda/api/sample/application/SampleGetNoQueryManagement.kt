package dapanda.api.sample.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.http.getStartTime
import dapanda.api.sample.blanco.SampleGetNoQueryGetRequest
import dapanda.api.sample.blanco.SampleGetNoQueryGetResponse
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleGetNoQueryManagement (private val apiBase: ApiBase) : IApiBase by apiBase {

    fun doGet(httpCommonRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleGetNoQueryGetRequest>>): HttpResponse<CommonResponse<ResponseHeader, SampleGetNoQueryGetResponse>> {
        var responseLocale = blanco.restgenerator.valueobject.Locale()
        httpCommonRequest.commonRequest?.let {
            responseLocale = it.info.locale
        }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpCommonRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )
        val responseTelegram = SampleGetNoQueryGetResponse()

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }
}
