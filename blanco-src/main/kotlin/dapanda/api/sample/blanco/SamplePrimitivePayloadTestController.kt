/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.HttpPrimitiveRequest
import dapanda.api.sample.application.SamplePrimitivePayloadTestManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.Optional

/** primitivePayloadテスト用API&lt;br&gt; */
@Controller("/sample_primitive")
class SamplePrimitivePayloadTestController
constructor(
    /** The implementation class to be called by SamplePrimitivePayloadTestController. */
    var samplePrimitivePayloadTestManagement: SamplePrimitivePayloadTestManagement
) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argUserId ユーザーID
   * @param argPassword パスワード
   * @return validation済みのレスポンス情報です
   */
  @Get("/{userId}{?password}")
  fun doGet(
      argHttpRequest: HttpRequest<*>,
      @PathVariable("userId") argUserId: String,
      @QueryValue("password") argPassword: Optional<String>
  ): HttpResponse<String> {
    val requestBean =
        dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetRequest(
            userId = argUserId,
            password = if (argPassword.isPresent == true) argPassword.get() else "")

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest
            as HttpRequest<dapanda.api.sample.blanco.SamplePrimitivePayloadTestGetRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    samplePrimitivePayloadTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = samplePrimitivePayloadTestManagement.doGet(httpCommonRequest)

    /* Postprocessing */
    samplePrimitivePayloadTestManagement.finishPrimitive(httpResponse, httpCommonRequest)

    return httpResponse
  }

  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argUserId ユーザーID
   * @param argPassword パスワード
   * @return validation済みのレスポンス情報です
   */
  @Post("/{userId}/{password}")
  fun doPost(
      argHttpRequest: HttpRequest<*>,
      @PathVariable("userId") argUserId: String,
      @PathVariable("password") argPassword: String,
      @Body argRequestBody: String
  ): HttpResponse<String> {
    val requestBean =
        dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest(
            userId = argUserId, password = argPassword)

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest
            as HttpRequest<dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)
    val httpPrimitiveRequest = HttpPrimitiveRequest(typedHttpRequest, true, listOf(), null, argRequestBody)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean
    httpPrimitiveRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    samplePrimitivePayloadTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = samplePrimitivePayloadTestManagement.doPost(httpPrimitiveRequest)

    /* Postprocessing */
    samplePrimitivePayloadTestManagement.finishPrimitive(httpResponse, httpPrimitiveRequest)

    return httpResponse
  }
}
