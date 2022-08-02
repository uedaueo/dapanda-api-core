package dapanda.api.sample.infrastructure.verifier

import dapanda.api.sample.blanco.db.query.SampleValidTokenSelectIterator
import dapanda.api.sample.blanco.db.row.SampleValidTokenSelectRow
import dapanda.api.sample.domain.verifier.ISampleTokenInfoQuery
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * トークン情報を取得するクエリ
 */
@Singleton
class SampleTokenInfoQuery(
    private val dataSource: DataSource
) : ISampleTokenInfoQuery {
    override fun getValidTokenInfo(token: String, expiredDateTime: Long): SampleValidTokenSelectRow? {
        return dataSource.connection.use { connection ->
            val iterator = SampleValidTokenSelectIterator(connection)
            runCatching {
                // 検索条件を設定
                iterator.setInputParameter(
                    token,
                    expiredDateTime
                )
                // 検索実行
                // iterator.executeQuery()
                // iterator.takeIf { iterator.next() }?.row
                val row = SampleValidTokenSelectRow()
                row.userId = "yest0001"
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