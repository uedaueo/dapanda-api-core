package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

/** APIが返すエラーを定義します */
@Introspected
@Serdeable
data class ErrorTelegram
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
) : ApiTelegram()
