package dapanda.api.common.domain.model.http

import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.*
import io.micronaut.http.HttpResponse

/**
 * 共通ユーティリティ関数の定義です
 */
interface IApiBase {
    /**
     * APIのリクエストパラメータの初期処理を行います。
     */
    fun <S : RequestHeader, T : ApiTelegram> prepare(
        httpRequest: HttpCommonRequest<CommonRequest<S, T>>
    )

    /**
     * APIのリクエストパラメータの後処理を行います。
     */
    fun <S : RequestHeader, T1 : ApiTelegram, T2 : ApiTelegram> finish(
        httpResponse: HttpResponse<CommonResponse<T1>>,
        httpRequest: HttpCommonRequest<CommonRequest<S, T2>>
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
    fun <T : ApiTelegram> createCommonResponse(telegram: T): CommonResponse<T>

    /**
     * 型を確定した CommonRequest を生成します。
     */
    fun <S : RequestHeader, T : ApiTelegram> createCommonRequest(info: S, telegram: T?): CommonRequest<S, T>
}