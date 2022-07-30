package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.RequestHeader
import io.micronaut.http.HttpRequest

/**
 * 認証用の token 文字列をリクエスト属性に格納するキー
 */
private const val TOKEN_STRING_ATTRIBUTE_KEY = "####TOKEN_STRING_ATTRIBUTE_KEY####"

/**
 * 開始日時をリクエスト属性に格納するキー
 */
private const val START_TIME_KEY = "####COMMON_START_TIME_KEY####"

/**
 * リクエストヘッダから情報を取得します。
 *
 * @param info ScreenApiRequestHeader
 */
fun HttpRequest<*>.processHeaderInfo(info: RequestHeader) {
    /* 認証用tokenをリクエスト属性に格納する */
    /*
    if (info.token != null) {
        this.attributes.put(TOKEN_STRING_ATTRIBUTE_KEY, info.token)
    }
     */
}

/**
 * トークン文字列を取得します。
 *
 * @return String トークン文字列
 */
fun HttpRequest<*>.getToken(): String =
    this.attributes.get(TOKEN_STRING_ATTRIBUTE_KEY, String::class.java, "")

/**
 * 開始日時を設定する
 *
 */
fun <T> HttpRequest<T>.setStartTime(): HttpRequest<T> {
    this.attributes.put(START_TIME_KEY, System.currentTimeMillis())
    return this
}

/**
 * 開始日時を取得する
 *
 * @return 開始日時（ms）
 */
fun HttpRequest<*>.getStartTime(): Long =
    this.attributes.get(START_TIME_KEY, Long::class.java, 0)