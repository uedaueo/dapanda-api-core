package dapanda.api.sample.infrastructure.login

import dapanda.api.sample.blanco.db.query.SampleUserSelectIterator
import dapanda.api.sample.blanco.db.row.SampleUserSelectRow
import dapanda.api.sample.domain.login.ISampleLoginQuery
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ユーザー検索を行います。
 */
@Singleton
class SampleLoginQuery(
    private val dataSource: DataSource
) : ISampleLoginQuery {
    override fun findUser(userId: String): SampleUserSelectRow? {
        return dataSource.connection.use { connection ->
            val iterator = SampleUserSelectIterator(connection)
            runCatching {
                // 検索条件を設定
                iterator.setInputParameter(
                    userId
                )
                // 検索実行
                // iterator.executeQuery()
                // iterator.takeIf { iterator.next() }?.row
                val row = SampleUserSelectRow()
                row.password = "5a4794b699e08fe473849cca9e6ea14badd944522abdea1dd289419275368c7b"
                row
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