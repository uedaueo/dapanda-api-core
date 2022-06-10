package dapanda.api.common.domain.model.exceptions

import blanco.restgenerator.valueobject.ResponseMetaInfo

/**
 * API実行時例外を生成するファクトリです。
 */
object ApiRuntimeExceptionFactory {
    /**
     * API実行時例外を生成します。
     *
     * @param metaInfo APIのレスポンスに含む共通情報を表すオブジェクトです。
     * @param logMessage ログに記録されるメッセージです。
     * @param cause この例外が発生した原因となる例外です。
     */
    fun create(
        metaInfo: ResponseMetaInfo,
        logMessage: String,
        cause: Throwable? = null
    ): ApiRuntimeException {
        return ApiRuntimeException(
            httpStatus = metaInfo.httpStatus,
            result = metaInfo.resultCode,
            errorCode = metaInfo.errorCode,
            resultMessage = metaInfo.message,
            messageNumber = metaInfo.messageNumber,
            message = logMessage,
            cause = cause
        )
    }
}