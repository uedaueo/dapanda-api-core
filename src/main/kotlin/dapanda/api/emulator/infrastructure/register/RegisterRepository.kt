package dapanda.api.emulator.infrastructure.register

import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.emulator.blanco.db.query.UserInsertInvoker
import dapanda.api.emulator.domain.register.IRegisterRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ユーザーの登録に関連するデータの追加を行うリポジトリ
 */
@Singleton
class RegisterRepository(
    private val dataSource: DataSource
) : IRegisterRepository {
    companion object {
        /** ロガー */
        private val log by LoggerDelegate()
    }

    override fun add(userId: String, password: String) {
        return dataSource.connection.use { connection ->
            val iterator = UserInsertInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId, password)
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