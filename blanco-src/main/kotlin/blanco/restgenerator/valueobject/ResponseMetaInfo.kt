package blanco.restgenerator.valueobject

import dapanda.api.common.domain.CommonConstants.ResponseResultCode
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpStatus

/** APIのレスポンスに含む共通情報を表すオブジェクトです。 */
@Introspected
data class ResponseMetaInfo
constructor(
    /**
     * micronautが用意しているHttpRequest
     *
     * フィールド: [httpStatus]。
     */
    val httpStatus: HttpStatus,
    /**
     * API結果コード。&quot;10&quot;: 正常終了。&quot;20&quot;: エラー
     *
     * フィールド: [resultCode]。
     */
    val resultCode: ResponseResultCode,
    /**
     * エラーコード文字列
     *
     * フィールド: [errorCode]。
     */
    val errorCode: String,
    /**
     * メッセージ番号
     *
     * フィールド: [messageNumber]。 デフォルト: [&quot;&quot;]。
     */
    var messageNumber: String = "",
    /**
     * メッセージ
     *
     * フィールド: [message]。 デフォルト: [&quot;&quot;]。
     */
    var message: String = ""
)
