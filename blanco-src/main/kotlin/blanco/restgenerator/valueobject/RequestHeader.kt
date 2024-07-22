package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.Valid

/** 通信に関するメタ情報を表す型です */
@Serdeable
open class RequestHeader
constructor(
    /**
     * ロケール
     *
     * フィールド: [locale]。 デフォルト: [Locale()]。
     */
    @field:Valid @Nullable var locale: Locale = Locale(),
    /**
     * バージョン
     *
     * フィールド: [version]。 デフォルト: [&quot;&quot;]。
     */
    @field:Valid @Nullable var version: String = ""
)
