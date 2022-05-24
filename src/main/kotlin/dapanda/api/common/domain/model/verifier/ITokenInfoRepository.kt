package dapanda.api.common.domain.model.verifier

/**
 * トークン情報に変更を加えるリポジトリ
 */
interface ITokenInfoRepository {
    fun updateTokenExpired(token: String, expiredAt: Long)
}