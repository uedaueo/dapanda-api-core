package dapanda.api.common.domain.model.http

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import io.micronaut.http.HttpResponse

/**
 * 共通ユーティリティ関数の定義です
 */
interface IApiBasePlain {
    /**
     * APIのリクエストパラメータの初期処理を行います。
     */
    fun <T : ApiTelegram> prepare(
        httpRequest: HttpCommonRequest<T>
    )

    /**
     * APIのリクエストパラメータの後処理を行います。
     */
    fun <T1 : ApiTelegram, T2 : ApiTelegram> finish(
        httpResponse: HttpResponse<T1>,
        httpRequest: HttpCommonRequest<T2>
    )

    /**
     * APIが呼び出し可能かどうかを返します。
     */
    fun isSpoiled(method: String): Boolean
}
