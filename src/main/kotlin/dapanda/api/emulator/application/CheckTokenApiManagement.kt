package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.*
import dapanda.api.emulator.blanco.CheckTokenApiGetRequest
import dapanda.api.emulator.blanco.CheckTokenApiGetResponse
import dapanda.api.emulator.domain.Const
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton

/**
 * アプリケーションサーバから認証シーケンスサーバに対して要求する認可トークンの確認
 */
@Singleton
class CheckTokenApiManagement(
    private val apiBase: ApiBase,
) : IApiBase by apiBase {
    companion object {
        private val log by LoggerDelegate()
    }

    fun doGet(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, CheckTokenApiGetRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, CheckTokenApiGetResponse>> {
        val telegram: CheckTokenApiGetRequest = httpRequest.commonRequest?.telegram ?: return HttpResponse.serverError()
        if (telegram.token == Const.OK_TOKEN) {
            return HttpResponse.ok()
        } else if (telegram.token == Const.NG_TOKEN) {
            return HttpResponse.status(HttpStatus.FORBIDDEN)
        } else {
            log.error("Failed to check token")
            return HttpResponse.status(HttpStatus.FORBIDDEN)
        }
    }
}