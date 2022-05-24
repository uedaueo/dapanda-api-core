package dapanda.api.emulator.infrastructure.login

import dapanda.api.emulator.blanco.db.query.TokenDeleteInvoker
import dapanda.api.emulator.blanco.db.query.TokenInsertInvoker
import dapanda.api.emulator.domain.login.ILoginRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ログイン処理に関連するデータの追加、更新を行うリポジトリ
 */
@Singleton
class LoginRepository(
    private val dataSource: DataSource
) : ILoginRepository {
    override fun deleteToken(userId: String) {
        return dataSource.connection.use { connection ->
            val iterator = TokenDeleteInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId)
                iterator.executeUpdate()
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
            val iterator = TokenInsertInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId, token, expiredAt)
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