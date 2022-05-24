package dapanda.api.emulator.infrastructure.login

import dapanda.api.emulator.blanco.db.query.UserSelectIterator
import dapanda.api.emulator.blanco.db.row.UserSelectRow
import dapanda.api.emulator.domain.login.ILoginQuery
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ユーザー検索を行います。
 */
@Singleton
class LoginQuery(
    private val dataSource: DataSource
) : ILoginQuery {
    override fun findUser(userId: String): UserSelectRow? {
        return dataSource.connection.use { connection ->
            val iterator = UserSelectIterator(connection)
            runCatching {
                // 検索条件を設定
                iterator.setInputParameter(
                    userId
                )
                // 検索実行
                iterator.executeQuery()
                iterator.takeIf { iterator.next() }?.row
            }
                .also {
                    // 検索処理を閉じる
                    iterator.close()
                }
                // 結果を取得する。例外が発生していた場合は、スローする。
                .getOrThrow()
        }
    }
}