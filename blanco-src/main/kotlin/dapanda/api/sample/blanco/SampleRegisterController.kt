/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.sample.application.SampleRegisterManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

/** ユーザー登録API&lt;br&gt; */
@Controller("/sample_register")
class SampleRegisterController
constructor(
    /** The implementation class to be called by SampleRegisterController. */
    var sampleRegisterManagement: SampleRegisterManagement
) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argRequestBean bean that body json is binded to
   * @return validation済みのレスポンス情報です
   */
  @Post
  fun doPost(
      argHttpRequest: HttpRequest<SampleRegisterPostRequest>,
      @Body argRequestBean: SampleRegisterPostRequest
  ): HttpResponse<SampleRegisterPostResponse> {
    val httpCommonRequest =
        HttpCommonRequest<dapanda.api.sample.blanco.SampleRegisterPostRequest>(
            argHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = argRequestBean

    /* Performs preprocessing (validation, etc.) */
    sampleRegisterManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleRegisterManagement.doPost(httpCommonRequest)

    /* Postprocessing */
    sampleRegisterManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
