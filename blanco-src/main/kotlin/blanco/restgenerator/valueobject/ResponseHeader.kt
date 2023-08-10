package blanco.restgenerator.valueobject

import io.micronaut.serde.annotation.Serdeable
import javax.validation.Valid

/** APIが返すレスポンスのヘッダを表す型です */
@Serdeable
data class ResponseHeader
constructor(
    /**
     * ロケール
     *
     * フィールド: [locale]。 デフォルト: [Locale()]。
     */
    @field:Valid var locale: Locale = Locale(),
    /**
     * 処理時間（ミリ秒）
     *
     * フィールド: [time]。 デフォルト: [0]。
     */
    @field:Valid var time: Long = 0,
    /**
     * 処理結果（success/error）
     *
     * フィールド: [result]。 デフォルト: [&quot;&quot;]。
     */
    @field:Valid var result: String = ""
)
