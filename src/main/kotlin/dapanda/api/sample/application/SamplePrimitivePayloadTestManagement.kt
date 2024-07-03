package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.HttpPrimitiveRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.http.PlainHttpResponseFactory
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest
import dapanda.api.sample.blanco.interfaces.ISamplePrimitivePayloadTestManagement
import io.micronaut.http.HttpResponse

class SamplePrimitivePayloadTestManagement(
    private val apiBasePlain: ApiBasePlain
    ) : ISamplePrimitivePayloadTestManagement, IApiBasePlain by apiBasePlain {
    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doGet(httpRequest: HttpCommonRequest<SamplePrimitivePayloadTestGetRequest>): HttpResponse<String> {
        return PlainHttpResponseFactory.create("Get Primitive Body", httpRequest)
    }

    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doPost(httpRequest: HttpCommonRequest<SamplePrimitivePayloadTestPostRequest>): HttpResponse<String> {
        return PlainHttpResponseFactory.create("Post Primitive Body", httpRequest)
    }
}
