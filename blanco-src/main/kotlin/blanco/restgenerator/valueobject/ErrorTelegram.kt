package blanco.restgenerator.valueobject

/** APIが返すエラーを定義します */
data class ErrorTelegram
constructor(
    /**
     * エラーコード
     *
     * フィールド: [code]。 デフォルト: [&quot;&quot;]。
     */
    var code: String? = "",
    /**
     * エラーメッセージ
     *
     * フィールド: [message]。 デフォルト: [&quot;&quot;]。
     */
    var message: String? = ""
) : ApiTelegram()
