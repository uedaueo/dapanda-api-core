package dapanda.api.sample.infrastructure.register

import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.sample.blanco.db.query.SampleUserInsertInvoker
import dapanda.api.sample.domain.register.ISampleRegisterRepository
import jakarta.inject.Singleton
import javax.sql.DataSource

/**
 * ユーザーの登録に関連するデータの追加を行うリポジトリ
 */
@Singleton
class SampleRegisterRepository(
    private val dataSource: DataSource
) : ISampleRegisterRepository {
    companion object {
        /** ロガー */
        private val log by LoggerDelegate()
    }

    override fun add(userId: String, password: String) {
        return dataSource.connection.use { connection ->
            val iterator = SampleUserInsertInvoker(connection)
            runCatching {
                iterator.setInputParameter(userId, password)
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