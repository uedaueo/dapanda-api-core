package blanco.restgenerator.valueobject

import io.micronaut.serde.annotation.Serdeable

/** APIが返すメッセージ（エラー他）を定義します */
@Serdeable
data class MessageItem
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
)
