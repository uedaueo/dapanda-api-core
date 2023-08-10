package blanco.restgenerator.valueobject

import io.micronaut.serde.annotation.Serdeable
import javax.validation.Valid

/** 通信に関するメタ情報を表す型です */
@Serdeable
data class RequestHeader
constructor(
    /**
     * ロケール
     *
     * フィールド: [locale]。 デフォルト: [Locale()]。
     */
    @field:Valid var locale: Locale = Locale(),
    /**
     * バージョン
     *
     * フィールド: [version]。 デフォルト: [&quot;&quot;]。
     */
    @field:Valid var version: String = ""
)
