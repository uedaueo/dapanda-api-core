package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.Valid

/** APIが返すレスポンスのヘッダを表す型です */
@Serdeable
data class ResponseHeader
constructor(
    /**
     * ロケール
     *
     * フィールド: [locale]。 デフォルト: [Locale()]。
     */
    @field:Valid @Nullable var locale: Locale = Locale(),
    /**
     * 処理時間（ミリ秒）
     *
     * フィールド: [time]。 デフォルト: [0]。
     */
    @field:Valid @Nullable var time: Long = 0,
    /**
     * 処理結果（success/error）
     *
     * フィールド: [result]。 デフォルト: [&quot;&quot;]。
     */
    @field:Valid @Nullable var result: String = ""
)
