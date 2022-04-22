package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import javax.validation.Valid

/** 共通リクエストを表すオブジェクトです。 */
@Introspected
data class CommonRequest<S : RequestHeader, T : ApiTelegram>
    constructor(
        /**
         * 通信に関するメタ情報
         *
         * フィールド: [info]。 デフォルト: [null]。
         */
        @field:Valid var info: S,
        /**
         * API毎の要求電文, ApiTelegramを継承してAPI毎に独自の型を指定
         *
         * フィールド: [telegram]。 デフォルト: [null]。
         */
        @field:Valid var telegram: T?)
