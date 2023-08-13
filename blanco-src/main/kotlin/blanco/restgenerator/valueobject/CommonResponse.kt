package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import javax.validation.Valid

/** 共通レスポンスを表すオブジェクトです。 */
@Serdeable
data class CommonResponse<S : ResponseHeader, T : ApiTelegram>
constructor(
    /**
     * 通信に関するメタ情報
     *
     * フィールド: [info]。 デフォルト: [null]。
     */
    @field:Valid @Nullable var info: S? = null,
    /**
     * API毎の応答電文, ApiTelegramを継承してAPI毎に独自の型を指定
     *
     * フィールド: [telegram]。 デフォルト: [null]。
     */
    @Nullable var telegram: T? = null,
    /**
     * メッセージ・エラー情報
     *
     * フィールド: [messages]。 デフォルト: [ArrayList&lt;MessageItem&gt;()]。
     */
    @Nullable var messages: ArrayList<MessageItem>? = ArrayList<MessageItem>()
)
