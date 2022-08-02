package dapanda.api.sample.infrastructure.verifier

import dapanda.api.sample.blanco.db.query.SampleUpdateTokenExpiredInvoker
import dapanda.api.sample.domain.verifier.ISampleTokenInfoRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * トークン情報に変更を加えるリポジトリ
 */
@Singleton
class SampleTokenInfoRepository(
    private val dataSource: DataSource
): ISampleTokenInfoRepository {
    override fun updateTokenExpired(token: String, expiredAt: Long) {
        return dataSource.connection.use { connection ->
            val iterator = SampleUpdateTokenExpiredInvoker(connection)
            runCatching {
                iterator.setInputParameter(token, expiredAt)
                // iterator.executeSingleUpdate()
            }
                .also {
                    iterator.close()
                }
                .getOrThrow()
            connection.commit()
        }
    }
}