package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.Locale
import io.micronaut.http.HttpRequest

/**
 * 開始日時をリクエスト属性に格納するキー
 */
private const val START_TIME_KEY = "####COMMON_START_TIME_KEY####"
private const val REQUEST_HEADER_LOCALE_KEY = "####COMMON_REQUEST_HEADER_LOCALE_KEY####"

/**
 * Bearer トークン文字列を取得します。
 *
 * @return String トークン文字列
 */
fun HttpRequest<*>.getBearerToken(): String? {
    var result: String? = null
    val authorizationInfos = this.headers.authorization.get().split(" ")
    if (authorizationInfos[0] == "Bearer") {
        result = authorizationInfos[1]
    }

    return result
}

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

/**
 * RequestHeaderのLocaleを設定する
 *
 */
fun <T> HttpRequest<T>.setRequestHeaderLocale(locale: Locale): HttpRequest<T> {
    this.attributes.put(REQUEST_HEADER_LOCALE_KEY, locale)
    return this
}

/**
 * RequestHeaderのLocaleを取得する
 *
 * @return Locale
 */
fun HttpRequest<*>.getRequestHeaderLocale(): Locale =
    this.attributes.get(REQUEST_HEADER_LOCALE_KEY, Locale::class.java, Locale())
