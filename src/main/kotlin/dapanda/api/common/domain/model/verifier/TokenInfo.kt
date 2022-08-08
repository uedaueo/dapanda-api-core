package dapanda.api.common.domain.model.verifier

import io.micronaut.core.annotation.Introspected

/**
 * トークン情報
 *
 * @property token 認証用トークン
 * @property userId ユーザID
 */
@Introspected
data class TokenInfo(
    val token: String,
    val nowDateTime: Long,
    val expiredDateTime: Long
)
