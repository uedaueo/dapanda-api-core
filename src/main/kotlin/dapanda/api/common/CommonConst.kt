package dapanda.api.common

/**
 * 共通で使用する定数定義
 */
object CommonConst {
    const val PASSWORD_SALT = "salt"
    const val LOGIN_TOKEN_VALID_TERM = 60
    /**
     * 時間関係共通：ミリ秒と秒との間の変換倍率
     */
    const val RATIO_MILLISECOND_TO_SECOND: Int = 1000
}