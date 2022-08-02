package dapanda.api.sample.domain.verifier

/**
 * トークン情報に変更を加えるリポジトリ
 */
interface ISampleTokenInfoRepository {
    fun updateTokenExpired(token: String, expiredAt: Long)
}