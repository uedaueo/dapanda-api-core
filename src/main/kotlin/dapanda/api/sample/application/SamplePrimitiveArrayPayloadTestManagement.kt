package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.HttpPrimitiveRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.http.PlainHttpResponseFactory
import dapanda.api.sample.blanco.SamplePrimitiveArrayPayloadTestGetRequest
import dapanda.api.sample.blanco.SamplePrimitiveArrayPayloadTestPostRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest
import dapanda.api.sample.blanco.interfaces.ISamplePrimitiveArrayPayloadTestManagement
import dapanda.api.sample.blanco.interfaces.ISamplePrimitivePayloadTestManagement
import io.micronaut.http.HttpResponse

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
    override fun doPost(httpRequest: HttpPrimitiveRequest<SamplePrimitiveArrayPayloadTestPostRequest, List<String>>): HttpResponse<List<String>> {
        val responseBean = mutableListOf("Post Primitive element 01")
        responseBean += httpRequest.primitiveRequest!!
        return PlainHttpResponseFactory.create(responseBean, httpRequest)
    }
}


