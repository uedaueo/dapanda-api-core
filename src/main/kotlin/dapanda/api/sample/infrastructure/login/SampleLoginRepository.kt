package dapanda.api.sample.infrastructure.login

import dapanda.api.sample.blanco.db.query.SampleTokenDeleteInvoker
import dapanda.api.sample.blanco.db.query.SampleTokenInsertInvoker
import dapanda.api.sample.domain.login.ISampleLoginRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ログイン処理に関連するデータの追加、更新を行うリポジトリ
 */
@Singleton
class SampleLoginRepository(
    private val dataSource: DataSource
) : ISampleLoginRepository {
    override fun deleteToken(userId: String) {
        return dataSource.connection.use { connection ->
            val iterator = SampleTokenDeleteInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId)
                // iterator.executeUpdate()
            }
                .also {
                    iterator.close()
                }
                .getOrThrow()
            connection.commit()
        }
    }

    override fun addToken(userId: String, token: String, expiredAt: Long) {
        return dataSource.connection.use { connection ->
            val iterator = SampleTokenInsertInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId, token, expiredAt)
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