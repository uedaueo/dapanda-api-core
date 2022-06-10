package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** 共通レスポンスを表すオブジェクトです。 */
@Introspected
data class CommonResponse<T : ApiTelegram>
constructor(
    /**
     * 処理結果（success = 10/error = 20）
     *
     * フィールド: [result]。 デフォルト: [10]。
     */
    var result: Long = 10,
    /**
     * 処理時間（ミリ秒）
     *
     * フィールド: [errors]。 デフォルト: [ArrayList&lt;ErrorItem&gt;()]。
     */
    var errors: ArrayList<ErrorItem>? = ArrayList<ErrorItem>(),
    /** フィールド: [telegram]。 デフォルト: [null]。 */
    var telegram: T? = null,
    /** フィールド: [message]。 デフォルト: [null]。 */
    var message: String? = null
)
