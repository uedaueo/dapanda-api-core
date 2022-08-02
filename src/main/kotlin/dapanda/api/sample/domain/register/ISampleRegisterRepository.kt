package dapanda.api.sample.domain.register

/**
 * ユーザーの登録に関連するデータの追加を行うリポジトリ
 */
interface ISampleRegisterRepository {
    /**
     * ユーザーの登録
     */
    fun add(userId: String, password: String)
}