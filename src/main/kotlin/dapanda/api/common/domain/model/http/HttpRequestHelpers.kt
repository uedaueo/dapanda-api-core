package dapanda.api.common.domain.model.http

import blanco.restgenerator.valueobject.RequestHeader
import io.micronaut.http.HttpRequest

/**
 * 認証用の token 文字列をリクエスト属性に格納するキー
 */
private const val TOKEN_STRING_ATTRIBUTE_KEY = "####TOKEN_STRING_ATTRIBUTE_KEY####"

/**
 * リクエストヘッダから情報を取得します。
 *
 * @param info ScreenApiRequestHeader
 */
fun HttpRequest<*>.processHeaderInfo(info: RequestHeader) {
    /* 認証用tokenをリクエスト属性に格納する */
    if (info.token != null) {
        this.attributes.put(TOKEN_STRING_ATTRIBUTE_KEY, info.token)
    }
}

/**
 * トークン文字列を取得します。
 *
 * @return String トークン文字列
 */
fun HttpRequest<*>.getToken(): String =
    this.attributes.get(TOKEN_STRING_ATTRIBUTE_KEY, String::class.java, "")