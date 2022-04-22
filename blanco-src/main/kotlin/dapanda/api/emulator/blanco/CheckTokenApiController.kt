/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.emulator.blanco

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.emulator.application.CheckTokenApiManagement
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.RequestBean

/** アプリケーションサーバから認証シーケンスサーバに対して要求する認可トークン確認用APIです。 */
@Controller("/check_token_api")
class CheckTokenApiController
    constructor(
        /** The implementation class to be called by CheckTokenApiController. */
        var checkTokenApiManagement: CheckTokenApiManagement
    ) {
  /**
   * APIベースクラスから呼ばれる実行メソッドです
   *
   * @param argHttpRequest validation前のリクエスト情報です
   * @param bean get parameter set as bean.
   * @return validation済みのレスポンス情報です
   */
  @Get("{?token}")
  fun doGet(
      argHttpRequest: HttpRequest<CommonRequest<RequestHeader, CheckTokenApiGetRequest>>,
      @RequestBean bean: CheckTokenApiGetRequest
  ): HttpResponse<CommonResponse<CheckTokenApiGetResponse>> {
    /* Creates HttpCommonRequest with httpRequest as delegator. */
    /* At this stage, commonRequest is tentative.*/
    val httpCommonRequest =
        HttpCommonRequest<CommonRequest<RequestHeader, CheckTokenApiGetRequest>>(
            argHttpRequest, false, listOf(), null)

    val info = RequestHeader()
    val commonRequest: CommonRequest<RequestHeader, CheckTokenApiGetRequest> =
        CommonRequest(info, bean)

    /* Stores the commonRequest with its type determined */
    httpCommonRequest.commonRequest = commonRequest

    /* Performs preprocessing (validation, etc.) */
    checkTokenApiManagement.prepare(httpCommonRequest)

    /* Passes HttpCommonRequest */
    val httpResponse = checkTokenApiManagement.doGet(httpCommonRequest)

    /* Postprocessing */
    checkTokenApiManagement.finish(httpResponse, httpCommonRequest)

    return httpResponse
  }
}
