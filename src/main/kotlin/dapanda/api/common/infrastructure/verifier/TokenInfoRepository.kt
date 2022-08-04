package dapanda.api.common.infrastructure.verifier

import dapanda.api.common.blanco.db.query.UpdateTokenExpiredInvoker
import dapanda.api.common.domain.model.verifier.ITokenInfoRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * トークン情報に変更を加えるリポジトリ
 */
@Singleton
class TokenInfoRepository(
    private val dataSource: DataSource
): ITokenInfoRepository {
    override fun updateTokenExpired(token: String, expiredAt: Long) {
        return dataSource.connection.use { connection ->
            val iterator = UpdateTokenExpiredInvoker(connection)
            runCatching {
                iterator.setInputParameter(token, expiredAt)
                iterator.executeSingleUpdate()
            }
                .also {
                    iterator.close()
                }
                .getOrThrow()
            connection.commit()
        }
    }
}