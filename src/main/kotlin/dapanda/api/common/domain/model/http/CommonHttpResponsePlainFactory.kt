package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.*
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse

/**
 * レスポンスを生成します。
 */
object CommonHttpResponsePlainFactory {
    /**
     * アプリケーションからは電文以外に返す物がない場合（正常終了時）
     * plain 電文スタイル時。
     * 
     * @param telegram 返却予定電文
     */
    fun <T : ApiTelegram> create(telegram: T): MutableHttpResponse<T> {
        return HttpResponse.ok(
            telegram
        )
    }

    /**
     * エラー時のHttpResponse を生成します。
     * blanco固有のレスポンスを返さない場合に使います。
     *
     * @param errorCode エラーコード
     * @param message エラーメッセージ
     * @param httpStatus 返却ステータス
     */
    fun create(
        errorCode: String,
        message: String,
        httpStatus: HttpStatus
    ): MutableHttpResponse<ArrayList<MessageItem>> {
        val errors: ArrayList<MessageItem> = ArrayList()
        errors.add(MessageItem(errorCode, message))
        return HttpResponse
            .status<ArrayList<MessageItem>>(httpStatus)
            .body(errors)
    }

    /**
     * 複数のエラー結果のHttpResponse を生成します。
     * blanco固有のレスポンスを返さない場合に使います。
     * 複数のエラーを返したい場合。
     *
     * @param errors エラーリスト
     * @param httpStatus 返却ステータス
     */
    fun create(
        errors: ArrayList<MessageItem>,
        httpStatus: HttpStatus
    ): MutableHttpResponse<ArrayList<MessageItem>> {
        return HttpResponse
            .status<ArrayList<MessageItem>>(httpStatus)
            .body(errors)
    }

    /**
     * エラー時のHttpResponse を生成します。
     * blanco固有のレスポンスを返さない場合に使います。
     *
     * @param httpStatus 返却ステータス
     * @param telegram エラー電文
     */
    fun create(
        httpStatus: HttpStatus,
        telegram: ApiTelegram
    ): MutableHttpResponse<ApiTelegram> {
        return HttpResponse.status<ApiTelegram>(httpStatus).body(telegram)
    }
}