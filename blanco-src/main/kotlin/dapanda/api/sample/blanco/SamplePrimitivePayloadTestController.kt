/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.sample.application.SamplePrimitivePayloadTestManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.QueryValue
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
    samplePrimitivePayloadTestManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }

  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argUserId ユーザーID
   * @param argPassword パスワード
   * @param argRequestBean bean that body json is binded to
   * @return validation済みのレスポンス情報です
   */
  @Post("/{userId}/{password}")
  fun doPost(
      argHttpRequest: HttpRequest<*>,
      @PathVariable("userId") argUserId: String,
      @PathVariable("password") argPassword: String,
      @Body argRequestBean: String
  ): HttpResponse<String> {
    val requestBean =
        dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest(
            userId = argUserId, password = argPassword, argBody = argRequestBean)

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest
            as HttpRequest<dapanda.api.sample.blanco.SamplePrimitivePayloadTestPostRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    samplePrimitivePayloadTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = samplePrimitivePayloadTestManagement.doPost(httpCommonRequest)

    /* Postprocessing */
    samplePrimitivePayloadTestManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }

  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argUserId ユーザーID
   * @param argPassword パスワード
   * @param argRequestBean bean that body json is binded to
   * @return validation済みのレスポンス情報です
   */
  @Put("/{userId}/{password}")
  fun doPut(
      argHttpRequest: HttpRequest<*>,
      @PathVariable("userId") argUserId: String,
      @PathVariable("password") argPassword: String,
      @Body argRequestBean: Optional<String>
  ): HttpResponse<String> {
    val requestBean =
        dapanda.api.sample.blanco.SamplePrimitivePayloadTestPutRequest(
            userId = argUserId,
            password = argPassword,
            argBody = if (argRequestBean.isPresent == true) argRequestBean.get() else null)

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest
            as HttpRequest<dapanda.api.sample.blanco.SamplePrimitivePayloadTestPutRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    samplePrimitivePayloadTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = samplePrimitivePayloadTestManagement.doPut(httpCommonRequest)

    /* Postprocessing */
    samplePrimitivePayloadTestManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
