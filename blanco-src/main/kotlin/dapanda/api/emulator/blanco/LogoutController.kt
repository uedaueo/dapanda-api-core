/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.emulator.blanco

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.emulator.application.LogoutManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Put

/** ログアウトAPI&lt;br&gt; */
@Controller("/logout")
class LogoutController
constructor(
    /** The implementation class to be called by LogoutController. */
    var logoutManagement: LogoutManagement
) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param argBody Raw JSON body.
   * @return validation済みのレスポンス情報です
   */
  @Put
  fun doPut(
      argHttpRequest: HttpRequest<CommonRequest<RequestHeader, LogoutPutRequest>>,
      @Body argBody: String
  ): HttpResponse<CommonResponse<LogoutPutResponse>> {
    /* Creates a CommonRequest instance from a JSON string. */
    val deserializer =
        BlancoRestGeneratorKtRequestDeserializer<RequestHeader, LogoutPutRequest>(
            argHttpRequest.javaClass)
    deserializer.infoClazz = RequestHeader::class.java
    deserializer.telegramClazz = LogoutPutRequest::class.java

    /* Creates HttpCommonRequest with httpRequest as delegator. */
    /* At this stage, commonRequest is tentative.*/
    val httpCommonRequest =
        HttpCommonRequest<CommonRequest<RequestHeader, LogoutPutRequest>>(
            argHttpRequest, false, listOf(), null)

    val commonRequest: CommonRequest<RequestHeader, LogoutPutRequest> =
        logoutManagement.convertJsonToCommonRequest(argBody, deserializer, httpCommonRequest)

    /* Stores the commonRequest with its type determined */
    httpCommonRequest.commonRequest = commonRequest

    /* Performs preprocessing (validation, etc.) */
    logoutManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = logoutManagement.doPut(httpCommonRequest)

    /* Postprocessing */
    logoutManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}