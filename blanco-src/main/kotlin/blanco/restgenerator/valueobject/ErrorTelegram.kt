package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** APIが返すエラーを定義します */
@Introspected
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
