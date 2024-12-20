/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.HttpCommonRequest
import dapanda.api.sample.application.SampleMethodTestManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.QueryValue
import java.util.Optional

/** Methodテスト用API&lt;br&gt; */
@Controller("/sample_methods")
class SampleMethodTestController
constructor(
    /** The implementation class to be called by SampleMethodTestController. */
    var sampleMethodTestManagement: SampleMethodTestManagement
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
  ): HttpResponse<SampleMethodTestGetResponse> {
    val requestBean =
        dapanda.api.sample.blanco.SampleMethodTestGetRequest(
            userId = argUserId,
            password = if (argPassword.isPresent == true) argPassword.get() else "")

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest as HttpRequest<dapanda.api.sample.blanco.SampleMethodTestGetRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    sampleMethodTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleMethodTestManagement.doGet(httpCommonRequest)

    /* Postprocessing */
    sampleMethodTestManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }

  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argUserId ユーザーID
   * @param argRequestBean bean that body json is binded to
   * @return validation済みのレスポンス情報です
   */
  @Post("/{userId}")
  fun doPost(
      argHttpRequest: HttpRequest<SampleMethodTestPostRequest>,
      @PathVariable("userId") argUserId: String,
      @Body argRequestBean: SampleMethodTestPostRequestBody
  ): HttpResponse<SampleMethodTestPostResponse> {
    val requestBean =
        dapanda.api.sample.blanco.SampleMethodTestPostRequest(
            userId = argUserId, password = argRequestBean.password)

    val httpCommonRequest =
        HttpCommonRequest<dapanda.api.sample.blanco.SampleMethodTestPostRequest>(
            argHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    sampleMethodTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleMethodTestManagement.doPost(httpCommonRequest)

    /* Postprocessing */
    sampleMethodTestManagement.finish(httpResponse, httpCommonRequest)

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
  @Put("/{userId}{?password}")
  fun doPut(
      argHttpRequest: HttpRequest<*>,
      @PathVariable("userId") argUserId: String,
      @QueryValue("password") argPassword: Optional<String>
  ): HttpResponse<SampleMethodTestPutResponse> {
    val requestBean =
        dapanda.api.sample.blanco.SampleMethodTestPutRequest(
            userId = argUserId,
            password = if (argPassword.isPresent == true) argPassword.get() else "")

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest as HttpRequest<dapanda.api.sample.blanco.SampleMethodTestPutRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    sampleMethodTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleMethodTestManagement.doPut(httpCommonRequest)

    /* Postprocessing */
    sampleMethodTestManagement.finish(httpResponse, httpCommonRequest)

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
  @Delete("{?userId,password}")
  fun doDelete(
      argHttpRequest: HttpRequest<*>,
      @QueryValue("userId") argUserId: Optional<String>,
      @QueryValue("password") argPassword: Optional<String>
  ): HttpResponse<SampleMethodTestDeleteResponse> {
    val requestBean =
        dapanda.api.sample.blanco.SampleMethodTestDeleteRequest(
            userId = if (argUserId.isPresent == true) argUserId.get() else "",
            password = if (argPassword.isPresent == true) argPassword.get() else "")

    @Suppress("UNCHECKED_CAST")
    val typedHttpRequest =
        argHttpRequest as HttpRequest<dapanda.api.sample.blanco.SampleMethodTestDeleteRequest>
    val httpCommonRequest = HttpCommonRequest(typedHttpRequest, true, listOf(), null)

    /* Stores the RequestBean with its type determined */
    httpCommonRequest.commonRequest = requestBean

    /* Performs preprocessing (validation, etc.) */
    sampleMethodTestManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = sampleMethodTestManagement.doDelete(httpCommonRequest)

    /* Postprocessing */
    sampleMethodTestManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
