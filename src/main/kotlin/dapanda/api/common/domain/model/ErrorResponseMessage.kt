package dapanda.api.common.domain.model

/**
 * クライアントに返却するレスポンスのエラーメッセージを定義
 */
object ErrorResponseMessage {
    val duplicateUserId: String
        get() = "そのユーザーIDはすでに登録されています。"

    val notFoundUserId: String
        get() = "そのユーザーIDは登録されていません。"

    val notVerifyPassword: String
        get() = "パスワードが間違っています。"

    val faildTokenAuthenticate: String
        get() = "トークン認証に失敗しました。"
}