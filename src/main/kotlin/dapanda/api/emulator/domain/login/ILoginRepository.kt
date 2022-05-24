package dapanda.api.emulator.domain.login

/**
 * ログイン処理に関連するデータの追加、更新を行うリポジトリ
 */
interface ILoginRepository {
    fun deleteToken(userId: String)
    fun addToken(userId: String, token: String, expiredAt: Long)
}