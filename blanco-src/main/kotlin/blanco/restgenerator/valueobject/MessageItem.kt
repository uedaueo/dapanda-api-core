package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** APIが返す通知メッセージを定義します */
@Introspected
data class MessageItem
constructor(
    /**
     * メッセージコード（主にエラー時に使用）
     *
     * フィールド: [code]。 デフォルト: [&quot;&quot;]。
     */
    var code: String? = "",
    /**
     * メッセージ
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
