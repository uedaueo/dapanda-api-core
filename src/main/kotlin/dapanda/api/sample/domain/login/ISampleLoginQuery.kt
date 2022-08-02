package dapanda.api.sample.domain.login

import dapanda.api.sample.blanco.db.row.SampleUserSelectRow

/**
 * ユーザー検索を行います。
 */
interface ISampleLoginQuery {
    /**
     * ユーザー検索
     */
    fun findUser(userId: String): SampleUserSelectRow?
}