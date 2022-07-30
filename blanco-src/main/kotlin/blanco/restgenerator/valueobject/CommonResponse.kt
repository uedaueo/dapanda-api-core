package blanco.restgenerator.valueobject

import javax.validation.Valid

/** 共通レスポンスを表すオブジェクトです。 */
data class CommonResponse<S : ResponseHeader, T : ApiTelegram>
constructor(
    /**
     * 通信に関するメタ情報
     *
     * フィールド: [info]。 デフォルト: [null]。
     */
    @field:Valid var info: S? = null,
    /**
     * API毎の応答電文, ApiTelegramを継承してAPI毎に独自の型を指定
     *
     * フィールド: [telegram]。 デフォルト: [null]。
     */
    var telegram: T? = null,
    /**
     * メッセージ・エラー情報
     *
     * フィールド: [messages]。 デフォルト: [ArrayList&lt;MessageItem&gt;()]。
     */
    var messages: ArrayList<MessageItem>? = ArrayList<MessageItem>()
)
