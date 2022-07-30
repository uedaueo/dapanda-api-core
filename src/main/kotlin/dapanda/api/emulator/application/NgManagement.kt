package dapanda.api.emulator.application

import blanco.restgenerator.valueobject.*
import dapanda.api.emulator.blanco.NgGetRequest
import dapanda.api.emulator.blanco.NgGetResponse
import dapanda.api.emulator.domain.Const
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import java.net.URI

/**
 * アプリケーションサーバへのLocation ヘッダを返すリダイレクトAPI
 * ngは認証に失敗するトークンを含んだヘッダを返します。
 */
@Singleton
class NgManagement(
    private val apiBase: ApiBase,
    ) : IApiBase by apiBase {
    fun doGet(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, NgGetRequest>>
    ): HttpResponse<CommonResponse<ResponseHeader, NgGetResponse>> {
        val telegram: NgGetRequest = httpRequest.commonRequest?.telegram ?: return HttpResponse.serverError()

        return HttpResponse.permanentRedirect(URI(createNgUri(telegram)))
    }

    private fun createNgUri(request: NgGetRequest): String {
        return Common.createUri(
            request.appServer,
            request.groupId,
            request.userId,
            Const.NG_TOKEN
        )
    }
}