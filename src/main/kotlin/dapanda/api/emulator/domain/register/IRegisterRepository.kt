package dapanda.api.emulator.domain.register

/**
 * ユーザーの登録に関連するデータの追加を行うリポジトリ
 */
interface IRegisterRepository {
    /**
     * ユーザーの登録
     */
    fun add(userId: String, password: String)
}