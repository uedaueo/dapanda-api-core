package dapanda.api.sample.domain.verifier

import io.micronaut.core.annotation.Introspected

/**
 * トークン情報
 *
 * @property token 認証用トークン
 * @property userId かっこユーザID
 */
@Introspected
data class SampleTokenInfo(
    val token: String,
    val nowDateTime: Long,
    val expiredDateTime: Long
)
