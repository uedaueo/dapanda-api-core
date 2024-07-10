package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.Valid

/** 共通リクエストを表すオブジェクトです。 */
@Introspected
@Serdeable
data class CommonRequest<S : RequestHeader, T : ApiTelegram>
constructor(
    /**
     * 通信に関するメタ情報
     *
     * フィールド: [info]。 デフォルト: [null]。
     */
    @field:Valid @Nullable var info: S,
    /**
     * API毎の要求電文, ApiTelegramを継承してAPI毎に独自の型を指定
     *
     * フィールド: [telegram]。 デフォルト: [null]。
     */
    @field:Valid @Nullable var telegram: T?
)
