package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Nullable
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
    @Nullable var code: String? = "",
    /**
     * エラーメッセージ
     *
     * フィールド: [message]。 デフォルト: [&quot;&quot;]。
     */
    @Nullable var message: String? = ""
)
