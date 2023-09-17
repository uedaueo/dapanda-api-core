package dapanda.api.sample.application

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.common.application.ApiBasePlain
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.http.PlainHttpResponseFactory
import dapanda.api.sample.blanco.SampleArrayPayloadTestGetRequest
import dapanda.api.sample.blanco.SampleArrayPayloadTestGetResponse
import dapanda.api.sample.blanco.SampleArrayPayloadTestPostRequest
import dapanda.api.sample.blanco.SampleArrayPayloadTestPostResponse
import dapanda.api.sample.blanco.interfaces.ISampleArrayPayloadTestManagement
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton

@Singleton
class SampleArrayPayloadTestManagement(
    private val apiBasePlain: ApiBasePlain
) : IApiBasePlain by apiBasePlain, ISampleArrayPayloadTestManagement {
    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doGet(httpRequest: HttpCommonRequest<SampleArrayPayloadTestGetRequest>): HttpResponse<List<SampleArrayPayloadTestGetResponse>> {
        val responseTelegram = mutableListOf<SampleArrayPayloadTestGetResponse>()
        responseTelegram.add(SampleArrayPayloadTestGetResponse("はじめのGet", 23))
        responseTelegram.add(SampleArrayPayloadTestGetResponse("つぎのGet", 25))

        return PlainHttpResponseFactory.create(
            responseTelegram, httpRequest
        )
    }

    /**
     * APIベースクラスから呼ばれる実行メソッドです
     *
     * @param httpRequest validation前のリクエスト情報です
     * @return validation済みのレスポンス情報です
     */
    override fun doPost(httpRequest: HttpCommonRequest<SampleArrayPayloadTestPostRequest>): HttpResponse<List<SampleArrayPayloadTestPostResponse>> {
        val responseTelegram = mutableListOf<SampleArrayPayloadTestPostResponse>()
        responseTelegram.add(SampleArrayPayloadTestPostResponse("はじめのPost", 26))
        responseTelegram.add(SampleArrayPayloadTestPostResponse("つぎのPost", 27))

        return PlainHttpResponseFactory.create(
            responseTelegram, httpRequest
        )
    }
}
