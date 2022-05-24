package dapanda.api.common.domain.model

/**
 * エラーログメッセージを定義
 */
object ErrorLogMessage {
    val valueRetrievedFromDatabaseIsNull: String
        get() = "データベースから取得した値がNULL"
}