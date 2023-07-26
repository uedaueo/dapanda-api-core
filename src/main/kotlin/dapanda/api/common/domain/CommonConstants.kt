package dapanda.api.common.domain

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializable
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.jsontype.TypeSerializer

/**
 * 共通で使用する定数定義
 */
object CommonConstants {
    /**
     * 時間関係共通：ミリ秒と秒との間の変換倍率
     */
    const val RATIO_MILLISECOND_TO_SECOND: Int = 1000

    /**
     * 時間関係共通：秒と分との間の変換倍率
     */
    const val RATIO_SECOND_TO_MINUTE: Int = 60

    /**
     * HTTPメソッド
     */
    const val HTTP_GET = "GET"
    const val HTTP_POST = "POST"
    const val HTTP_PUT = "PUT"
    const val HTTP_DELETE = "DELETE"

    /**
     * HTTP ヘッダ
     */
    const val X_DAPANDA_LANGUAGE = "X-Dapanda-Language"
    const val X_DAPANDA_TIMEZONE = "X-Dapanda-Timezone"
    const val X_DAPANDA_CURRENCY = "X-Dapanda-Currency"
    const val X_DAPANDA_ELAPSED_TIME = "X-Dapanda-Elapsed-Time"
    const val ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers"
    const val DEFAULT_EXPOSE_HEADERS = "X-Dapanda-Language,X-Dapanda-Timezone,X-Dapanda-Currency,X-Dapanda-Elapsed-Time"

    /**
     * 成功 HTTP レスポンス処理結果コード
     */
    private const val RESPONSE_RESULT_CODE_SUCCESS = 10

    /**
     * エラー HTTP レスポンス処理結果コード
     */
    private const val RESPONSE_RESULT_CODE_ERROR = 20

    /**
     * HTTP レスポンス処理結果コード
     */
    enum class ResponseResultCode(val code: Int) : JsonSerializable {

        /**
         * 成功
         */
        SUCCESS(RESPONSE_RESULT_CODE_SUCCESS),

        /**
         * エラー
         */
        ERROR(RESPONSE_RESULT_CODE_ERROR);

        override fun serialize(gen: JsonGenerator, serializers: SerializerProvider) {
            gen.writeNumber(code)
        }

        override fun serializeWithType(gen: JsonGenerator, serializers: SerializerProvider, typeSer: TypeSerializer) {
            gen.writeNumber(code)
        }
    }
}
