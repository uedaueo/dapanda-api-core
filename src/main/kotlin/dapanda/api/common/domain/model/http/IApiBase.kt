package dapanda.api.common.domain.model.http

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import io.micronaut.http.HttpResponse

/**
 * 共通ユーティリティ関数の定義です
 */
interface IApiBase {
    /**
     * APIのリクエストパラメータの初期処理を行います。
     */
    fun <S : RequestHeader, T : ApiTelegram> prepare(
        httpRequest: HttpCommonRequest<CommonRequest<S, T>>,
        authenticate: IAuthenticate
    )

    /**
     * APIのリクエストパラメータの後処理を行います。
     */
    fun <S1 : ResponseHeader, S2 : RequestHeader, T1 : ApiTelegram, T2 : ApiTelegram> finish(
        httpResponse: HttpResponse<CommonResponse<S1, T1>>,
        httpRequest: HttpCommonRequest<CommonRequest<S2, T2>>
    )

    /**
     * リクエストbodyのJSON文字列をCommonRequest<S, T> に変換します。
     */
    fun <S : RequestHeader, T : ApiTelegram> convertJsonToCommonRequest(
        body: String,
        deserializer: BlancoRestGeneratorKtRequestDeserializer<S, T>,
        argHttpRequest: HttpCommonRequest<CommonRequest<S, T>>
    ): CommonRequest<S, T>

    /**
     * HttpResponse に渡す為の CommonResponse を生成します。
     */
    fun <S : ResponseHeader, T : ApiTelegram> createCommonResponse(header: S, telegram: T): CommonResponse<S, T>

    /**
     * 型を確定した CommonRequest を生成します。
     */
    fun <S : RequestHeader, T : ApiTelegram> createCommonRequest(info: S, telegram: T?): CommonRequest<S, T>
}