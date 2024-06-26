/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco.interfaces

import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.HttpPrimitiveRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetResponse
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest
import dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostResponse
import io.micronaut.http.HttpResponse

/** primitivePayloadテスト用API&lt;br&gt; */
interface ISamplePrimitivePayloadTestManagement {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param httpRequest validation前のリクエスト情報です
   * @return validation済みのレスポンス情報です
   */
  fun doGet(
      httpRequest: HttpCommonRequest<SamplePrimitivePayloadTestGetRequest>
  ): HttpResponse<String>

  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param httpRequest validation前のリクエスト情報です
   * @return validation済みのレスポンス情報です
   */
  fun doPost(
      httpRequest: HttpPrimitiveRequest<SamplePrimitivePayloadTestPostRequest, String>
  ): HttpResponse<String>
}
