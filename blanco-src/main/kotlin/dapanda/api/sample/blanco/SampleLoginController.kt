/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import blanco.restgenerator.valueobject.ResponseHeader
import dapanda.api.sample.application.SampleLoginManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

/** ログインAPI&lt;br&gt; */
@Controller("/sample_login")
class SampleLoginController
constructor(
    /** The implementation class to be called by SampleLoginController. */
    var sampleLoginManagement: SampleLoginManagement
) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argBody Raw JSON body.
   * @return validation済みのレスポンス情報です
   */
  @Post
  fun doPost(
      argHttpRequest: HttpRequest<CommonRequest<RequestHeader, SampleLoginPostRequest>>,
      @Body argBody: String
  ): HttpResponse<CommonResponse<ResponseHeader, SampleLoginPostResponse>> {
    /* Creates a CommonRequest instance from a JSON string. */
    val deserializer =
        BlancoRestGeneratorKtRequestDeserializer<RequestHeader, SampleLoginPostRequest>(
            CommonRequest::class.java)
    deserializer.infoClazz = RequestHeader::class.java
    deserializer.telegramClazz = SampleLoginPostRequest::class.java

    /* Creates HttpCommonRequest with httpRequest as delegator. */
    /* At this stage, commonRequest is tentative.*/
    val httpCommonRequest =
        HttpCommonRequest<CommonRequest<RequestHeader, SampleLoginPostRequest>>(
            argHttpRequest, true, listOf(), null)

    val commonRequest: CommonRequest<RequestHeader, SampleLoginPostRequest> =
        sampleLoginManagement.convertJsonToCommonRequest(argBody, deserializer, httpCommonRequest)

    /* Stores the commonRequest with its type determined */
    httpCommonRequest.commonRequest = commonRequest

    /* Performs preprocessing (validation, etc.) */
    sampleLoginManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleLoginManagement.doPost(httpCommonRequest)

    /* Postprocessing */
    sampleLoginManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
