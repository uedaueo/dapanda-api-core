/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco.interfaces

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.sample.blanco.SampleRegisterPostRequest
import dapanda.api.sample.blanco.SampleRegisterPostResponse
import io.micronaut.http.HttpResponse

/** ユーザー登録API&lt;br&gt; */
interface ISampleRegisterManagement {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param httpRequest validation前のリクエスト情報です
   * @return validation済みのレスポンス情報です
   */
  fun doPost(
      httpRequest: HttpCommonRequest<SampleRegisterPostRequest>
  ): HttpResponse<SampleRegisterPostResponse>
}
