package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.http.PlainHttpResponseFactory
import dapanda.api.sample.blanco.*
import dapanda.api.sample.blanco.interfaces.ISamplePrimitiveArrayPayloadTestManagement
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SamplePrimitiveArrayPayloadTestManagement(
    private val apiBasePlain: ApiBasePlain
    ) : ISamplePrimitiveArrayPayloadTestManagement, IApiBasePlain by apiBasePlain {
    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doGet(httpRequest: HttpCommonRequest<SamplePrimitiveArrayPayloadTestGetRequest>): HttpResponse<List<String>> {
        val responseBean = mutableListOf("Get Primitive element 01", "Get Primitive element 02")
        return PlainHttpResponseFactory.create(responseBean, httpRequest)
    }

    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doPost(httpRequest: HttpCommonRequest<SamplePrimitiveArrayPayloadTestPostRequest>): HttpResponse<List<String>> {
        val responseBean = mutableListOf("Post Primitive element 01")
        responseBean += httpRequest.commonRequest?.argBody!!
        return PlainHttpResponseFactory.create(responseBean, httpRequest)
    }

    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doPut(httpRequest: HttpCommonRequest<SamplePrimitiveArrayPayloadTestPutRequest>): HttpResponse<List<String>> {
        val responseBean = mutableListOf("Put Primitive element 01")
        val requestBody = httpRequest.commonRequest?.argBody
        if (requestBody != null) {
            responseBean += requestBody
        }
        return PlainHttpResponseFactory.create(responseBean, httpRequest)
    }
}
