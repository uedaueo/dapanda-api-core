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