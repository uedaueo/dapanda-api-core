package dapanda.api.common.infrastructure.verifier

import dapanda.api.common.blanco.db.query.ValidTokenSelectIterator
import dapanda.api.common.blanco.db.row.ValidTokenSelectRow
import dapanda.api.common.domain.model.verifier.ITokenInfoQuery
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * トークン情報を取得するクエリ
 */
@Singleton
class TokenInfoQuery(
    private val dataSource: DataSource
) : ITokenInfoQuery {
    override fun getValidTokenInfo(token: String, expiredDateTime: Long): ValidTokenSelectRow? {
        return dataSource.connection.use { connection ->
            val iterator = ValidTokenSelectIterator(connection)
            runCatching {
                // 検索条件を設定
                iterator.setInputParameter(
                    token,
                    expiredDateTime
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