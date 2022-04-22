package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** 共通レスポンスを表すオブジェクトです。 */
@Introspected
data class CommonResponse<T : ApiTelegram>
    constructor(
        /** フィールド: [telegram]。 デフォルト: [null]。 */
        var telegram: T? = null)
