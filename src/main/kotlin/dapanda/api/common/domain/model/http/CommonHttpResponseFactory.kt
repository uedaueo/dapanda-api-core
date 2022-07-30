package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.*
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse

/**
 * レスポンスを生成します。
 */
object CommonHttpResponseFactory {
    /**
     * アプリケーションからは電文以外に返す物がない場合（正常終了時）
     *
     * @param telegram 返却予定電文
     */
    fun <S : ResponseHeader, T : ApiTelegram> create(info: S, telegram: T): MutableHttpResponse<CommonResponse<S, T>> {
        return HttpResponse.ok(
            CommonResponse<S, T>(
                info = info,
                telegram = telegram
            )
        )
    }

    /**
     * エラー時のHttpResponse を生成します。
     * エラーなので電文はありません。
     *
     * @param result リザルトコード
     * @param errorCode エラーコード
     * @param message エラーメッセージ
     * @param httpStatus 返却ステータス
     */
    fun create(
        info: ResponseHeader,
        errorCode: String,
        message: String,
        httpStatus: HttpStatus
    ): MutableHttpResponse<CommonResponse<ResponseHeader, ApiTelegram>> {
        val errors: ArrayList<MessageItem> = ArrayList()
        errors.add(MessageItem(errorCode, message))
        return HttpResponse
            .status<CommonResponse<ResponseHeader, ApiTelegram>>(httpStatus)
            .body(
                CommonResponse(
                    info = info,
                    messages = errors
                )
            )
    }

    /**
     * 複数のエラー結果のHttpResponse を生成します。
     * エラーなので電文はありません。
     * 複数のエラーを返したい場合。
     *
     * @param info レスポンスヘッダー
     * @param errors エラーリスト
     * @param httpStatus 返却ステータス
     */
    fun create(
        info: ResponseHeader,
        errors: ArrayList<MessageItem>,
        httpStatus: HttpStatus
    ): MutableHttpResponse<CommonResponse<ResponseHeader, ApiTelegram>> {
        return HttpResponse
            .status<CommonResponse<ResponseHeader, ApiTelegram>>(httpStatus)
            .body(
                CommonResponse(
                    info = info,
                    messages = errors
                )
            )
    }
}