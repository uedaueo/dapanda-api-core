/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.emulator.blanco

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.emulator.application.LoginManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

/** ログインAPI&lt;br&gt; */
@Controller("/login")
class LoginController
constructor(
    /** The implementation class to be called by LoginController. */
    var loginManagement: LoginManagement
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
      argHttpRequest: HttpRequest<CommonRequest<RequestHeader, LoginPostRequest>>,
      @Body argBody: String
  ): HttpResponse<CommonResponse<LoginPostResponse>> {
    /* Creates a CommonRequest instance from a JSON string. */
    val deserializer =
        BlancoRestGeneratorKtRequestDeserializer<RequestHeader, LoginPostRequest>(
            argHttpRequest.javaClass)
    deserializer.infoClazz = RequestHeader::class.java
    deserializer.telegramClazz = LoginPostRequest::class.java

    /* Creates HttpCommonRequest with httpRequest as delegator. */
    /* At this stage, commonRequest is tentative.*/
    val httpCommonRequest =
        HttpCommonRequest<CommonRequest<RequestHeader, LoginPostRequest>>(
            argHttpRequest, true, listOf(), null)

    val commonRequest: CommonRequest<RequestHeader, LoginPostRequest> =
        loginManagement.convertJsonToCommonRequest(argBody, deserializer, httpCommonRequest)

    /* Stores the commonRequest with its type determined */
    httpCommonRequest.commonRequest = commonRequest

    /* Performs preprocessing (validation, etc.) */
    loginManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = loginManagement.doPost(httpCommonRequest)

    /* Postprocessing */
    loginManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
