package blanco.restgenerator.valueobject

import io.micronaut.serde.annotation.Serdeable

/** ロケール情報 */
@Serdeable
data class Locale
constructor(
    /**
     * 言語コード．defaultはja
     *
     * フィールド: [lang]。 デフォルト: [&quot;ja&quot;]。
     */
    var lang: String = "ja",
    /**
     * 時間帯
     *
     * フィールド: [tz]。 デフォルト: [&quot;Asia/Tokyo&quot;]。
     */
    var tz: String = "Asia/Tokyo",
    /**
     * 通貨
     *
     * フィールド: [currency]。 デフォルト: [&quot;JPY&quot;]。
     */
    var currency: String = "JPY"
)
