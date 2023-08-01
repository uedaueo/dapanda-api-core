package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.MessageItem
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.common.Utilities
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse

/**
 * レスポンスを生成します。
 */
object PlainHttpResponseFactory {


    fun <T: ApiTelegram> appendExposeHeaders(response: MutableHttpResponse<T>, additionalHeaders: String): MutableHttpResponse<T> {
        var newHeaders = ""
        response.headers.getFirst(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS).let {
            if (it.isPresent) {
                newHeaders = it.get() + "," + additionalHeaders
                response.headers.remove(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS)
            } else {
                newHeaders = additionalHeaders
            }
        }
        return response.header(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS, newHeaders)
    }

    /**
     * アプリケーションからは電文以外に返す物がない場合（正常終了時）
     * plain 電文スタイル時。
     *
     * @param telegram 返却予定電文
     */
    fun <T: ApiTelegram> create(response: T, request: HttpCommonRequest<*>): MutableHttpResponse<T> {
        val blancoLocale = request.getRequestHeaderLocale()
        val elapsed = Utilities.getMeasurementTime(request.getStartTime())
        return HttpResponse.ok(
            response
        ).header(CommonConstants.X_DAPANDA_LANGUAGE, blancoLocale.lang)
            .header(CommonConstants.X_DAPANDA_TIMEZONE, blancoLocale.tz)
            .header(CommonConstants.X_DAPANDA_CURRENCY, blancoLocale.currency)
            .header(CommonConstants.X_DAPANDA_ELAPSED_TIME, elapsed.toString())
            .header(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS, CommonConstants.DEFAULT_EXPOSE_HEADERS)
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
        httpStatus: HttpStatus,
        request: HttpRequest<*>
    ): MutableHttpResponse<ArrayList<MessageItem>> {
        val errors: ArrayList<MessageItem> = ArrayList()
        errors.add(MessageItem(errorCode, message))
        val blancoLocale = request.getRequestHeaderLocale()
        val elapsed = Utilities.getMeasurementTime(request.getStartTime())
        return HttpResponse
            .status<ArrayList<MessageItem>>(httpStatus)
            .body(errors)
            .header(CommonConstants.X_DAPANDA_LANGUAGE, blancoLocale.lang)
            .header(CommonConstants.X_DAPANDA_TIMEZONE, blancoLocale.tz)
            .header(CommonConstants.X_DAPANDA_CURRENCY, blancoLocale.currency)
            .header(CommonConstants.X_DAPANDA_ELAPSED_TIME, elapsed.toString())
            .header(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS, CommonConstants.DEFAULT_EXPOSE_HEADERS)
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
        httpStatus: HttpStatus,
        request: HttpRequest<*>
    ): MutableHttpResponse<ArrayList<MessageItem>> {
        val blancoLocale = request.getRequestHeaderLocale()
        val elapsed = Utilities.getMeasurementTime(request.getStartTime())
        return HttpResponse
            .status<ArrayList<MessageItem>>(httpStatus)
            .body(errors)
            .header(CommonConstants.X_DAPANDA_LANGUAGE, blancoLocale.lang)
            .header(CommonConstants.X_DAPANDA_TIMEZONE, blancoLocale.tz)
            .header(CommonConstants.X_DAPANDA_CURRENCY, blancoLocale.currency)
            .header(CommonConstants.X_DAPANDA_ELAPSED_TIME, elapsed.toString())
            .header(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS, CommonConstants.DEFAULT_EXPOSE_HEADERS)
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
        telegram: ApiTelegram,
        request: HttpRequest<*>
    ): MutableHttpResponse<ApiTelegram> {
        val blancoLocale = request.getRequestHeaderLocale()
        val elapsed = Utilities.getMeasurementTime(request.getStartTime())
        return HttpResponse.status<ApiTelegram>(httpStatus).body(telegram)
            .header(CommonConstants.X_DAPANDA_LANGUAGE, blancoLocale.lang)
            .header(CommonConstants.X_DAPANDA_TIMEZONE, blancoLocale.tz)
            .header(CommonConstants.X_DAPANDA_CURRENCY, blancoLocale.currency)
            .header(CommonConstants.X_DAPANDA_ELAPSED_TIME, elapsed.toString())
            .header(CommonConstants.ACCESS_CONTROL_EXPOSE_HEADERS, CommonConstants.DEFAULT_EXPOSE_HEADERS)
    }
}
