package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.ErrorItem
import dapanda.api.common.domain.CommonConstants
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
    fun <T : ApiTelegram> create(telegram: T): MutableHttpResponse<CommonResponse<T>> {
        return HttpResponse.ok(
            CommonResponse<T>(
                result = CommonConstants.ResponseResultCode.SUCCESS.code.toLong(),
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
     * @param messageNumber メッセージ番号
     * @param message エラーメッセージ
     * @param httpStatus 返却ステータス
     */
    fun create(
        result: Long,
        errorCode: String,
        messageNumber: String?,
        message: String,
        httpStatus: HttpStatus
    ): MutableHttpResponse<CommonResponse<ApiTelegram>> {
        var errors: ArrayList<ErrorItem> = ArrayList()
        var number: String? = null
        if ((messageNumber != null) && messageNumber.isNotEmpty()) {
            number = messageNumber
        }
        errors.add(ErrorItem(errorCode, message, number))
        return HttpResponse
            .status<CommonResponse<ApiTelegram>>(httpStatus)
            .body(
                CommonResponse(
                    result = result,
                    errors = errors
                )
            )
    }

    /**
     * 複数のエラー結果のHttpResponse を生成します。
     * エラーなので電文はありません。
     * 複数のエラーを返したい場合。
     *
     * @param result リザルトコード
     * @param errors エラーリスト
     * @param httpStatus 返却ステータス
     */
    fun create(
        result: Long,
        errors: ArrayList<ErrorItem>,
        httpStatus: HttpStatus
    ): MutableHttpResponse<CommonResponse<ApiTelegram>> {
        return HttpResponse
            .status<CommonResponse<ApiTelegram>>(httpStatus)
            .body(
                CommonResponse(
                    result = result,
                    errors = errors
                )
            )
    }
}