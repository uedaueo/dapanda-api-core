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

    fun doGet(httpCommonRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleMethodTestGetRequest>>): HttpResponse<CommonResponse<ResponseHeader, SampleMethodTestGetResponse>> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        httpCommonRequest.commonRequest?.let {
            responseLocale = it.info.locale
        }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpCommonRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )
        val responseTelegram = SampleMethodTestGetResponse()

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }

    fun doPost(httpCommonRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleMethodTestPostRequest>>): HttpResponse<CommonResponse<ResponseHeader, SampleMethodTestPostResponse>> {
        var responseLocale = blanco.restgenerator.valueobject.Locale()
        httpCommonRequest.commonRequest?.let {
            responseLocale = it.info.locale
        }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpCommonRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )
        val responseTelegram = SampleMethodTestPostResponse()

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }

    fun doPut(httpCommonRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleMethodTestPutRequest>>): HttpResponse<CommonResponse<ResponseHeader, SampleMethodTestPutResponse>> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        httpCommonRequest.commonRequest?.let {
            responseLocale = it.info.locale
        }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpCommonRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )
        val responseTelegram = SampleMethodTestPutResponse()

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }

    fun doDelete(httpCommonRequest: HttpCommonRequest<CommonRequest<RequestHeader, SampleMethodTestDeleteRequest>>): HttpResponse<CommonResponse<ResponseHeader, SampleMethodTestDeleteResponse>> {

        var responseLocale = blanco.restgenerator.valueobject.Locale()
        httpCommonRequest.commonRequest?.let {
            responseLocale = it.info.locale
        }
        val responseHeader = ResponseHeader(
            responseLocale,
            Utilities.getMeasurementTime(httpCommonRequest.getStartTime()),
            CommonConstants.ResponseResultCode.SUCCESS.name
        )
        val responseTelegram = SampleMethodTestDeleteResponse()

        return CommonHttpResponseFactory.create(
            responseHeader,
            responseTelegram
        )
    }
}
