/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.sample.application.SampleLogoutManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Put

/** ログアウトAPI&lt;br&gt; */
@Controller("/sample_logout")
class SampleLogoutController
constructor(
    /** The implementation class to be called by SampleLogoutController. */
    var sampleLogoutManagement: SampleLogoutManagement
) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argRequestBean bean that body json is binded to
   * @return validation済みのレスポンス情報です
   */
  @Put
  fun doPut(
      argHttpRequest: HttpRequest<SampleLogoutPutRequest>,
      @Body argRequestBean: SampleLogoutPutRequestBody
  ): HttpResponse<SampleLogoutPutResponse> {
    val requestBean =
        dapanda.api.sample.blanco.SampleLogoutPutRequest(userId = argRequestBean.userId)

    val httpCommonRequest =
        HttpCommonRequest<dapanda.api.sample.blanco.SampleLogoutPutRequest>(
            argHttpRequest, false, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    sampleLogoutManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleLogoutManagement.doPut(httpCommonRequest)

    /* Postprocessing */
    sampleLogoutManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
