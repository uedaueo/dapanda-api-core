package dapanda.api.emulator.domain.login

import dapanda.api.emulator.blanco.db.row.UserSelectRow

/**
 * ユーザー検索を行います。
 */
interface ILoginQuery {
    /**
     * ユーザー検索
     */
    fun findUser(userId: String): UserSelectRow?
}