package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** APIが返すエラーを定義します */
@Introspected
data class ErrorItem
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
    var message: String? = "",
    /**
     * メッセージナンバー（主に画面API用に使用）
     *
     * フィールド: [messageNumber]。 デフォルト: [&quot;&quot;]。
     */
    var messageNumber: String? = ""
)
