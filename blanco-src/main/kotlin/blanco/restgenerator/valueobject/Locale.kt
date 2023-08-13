package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Nullable
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
    @Nullable var lang: String = "ja",
    /**
     * 時間帯
     *
     * フィールド: [tz]。 デフォルト: [&quot;Asia/Tokyo&quot;]。
     */
    @Nullable var tz: String = "Asia/Tokyo",
    /**
     * 通貨
     *
     * フィールド: [currency]。 デフォルト: [&quot;JPY&quot;]。
     */
    @Nullable var currency: String = "JPY"
)
