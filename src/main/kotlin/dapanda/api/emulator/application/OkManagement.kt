package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.*
import dapanda.api.emulator.blanco.OkGetRequest
import dapanda.api.emulator.blanco.OkGetResponse
import dapanda.api.emulator.domain.Const
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import dapanda.api.emulator.application.Common
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.net.URI

/**
 * アプリケーションサーバへのLocation ヘッダを返すリダイレクトAPI
 * okは認証に成功するトークンを含んだヘッダを返します。
 */
@Singleton
class OkManagement(
    private val apiBase: ApiBase,
    ) : IApiBase by apiBase {
    fun doGet(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, OkGetRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, OkGetResponse>> {
        val telegram: OkGetRequest = httpRequest.commonRequest?.telegram ?: return HttpResponse.serverError()

        return HttpResponse.permanentRedirect(URI(createOkUri(telegram)))
    }

    private fun createOkUri(request: OkGetRequest): String {
        return Common.createUri(
            request.appServer,
            request.groupId,
            request.userId,
            Const.OK_TOKEN
        )
    }
}