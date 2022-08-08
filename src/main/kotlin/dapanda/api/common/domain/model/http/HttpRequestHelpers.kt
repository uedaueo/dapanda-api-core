package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.RequestHeader
import io.micronaut.http.HttpRequest

/**
 * 開始日時をリクエスト属性に格納するキー
 */
private const val START_TIME_KEY = "####COMMON_START_TIME_KEY####"

/**
 * トークン文字列を取得します。
 *
 * @return String トークン文字列
 */
fun HttpRequest<*>.getToken(): String? {
    var result: String? = null
    val authorizationInfos = this.headers.authorization.get().split(" ")
    if (authorizationInfos[1] == "Bearer") {
        result = authorizationInfos[2]
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