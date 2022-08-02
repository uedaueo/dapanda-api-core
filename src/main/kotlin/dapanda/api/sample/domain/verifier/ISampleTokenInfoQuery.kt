package dapanda.api.sample.domain.verifier

import dapanda.api.sample.blanco.db.row.SampleValidTokenSelectRow

/**
 * トークン情報を取得するクエリ
 */
interface ISampleTokenInfoQuery {
    /**
     * 有効なToken情報を取得
     */
    fun getValidTokenInfo(token: String, expiredDateTime: Long): SampleValidTokenSelectRow?
}