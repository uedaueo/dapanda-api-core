package dapanda.api.common.domain.model.verifier

import dapanda.api.common.blanco.db.row.ValidTokenSelectRow

/**
 * トークン情報を取得するクエリ
 */
interface ITokenInfoQuery {
    /**
     * 有効なToken情報を取得
     */
    fun getValidTokenInfo(token: String, expiredDateTime: Long): ValidTokenSelectRow?
}