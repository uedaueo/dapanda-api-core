package dapanda.api.common.domain.model.exceptions

import blanco.restgenerator.valueobject.ErrorItem
import blanco.restgenerator.valueobject.ResponseMetaInfo

/**
 * API実行時例外を生成するファクトリです。
 */
object DapandaApiRuntimeExceptionFactory {
    /**
     * API実行時例外を生成します。
     *
     * @param errors エラーリスト
     * @param metaInfo APIのレスポンスに含む共通情報を表すオブジェクトです。
     * @param logMessage ログに記録されるメッセージです。
     * @param cause この例外が発生した原因となる例外です。
     */
    fun create(
        errors: ArrayList<ErrorItem>,
        metaInfo: ResponseMetaInfo,
        logMessage: String,
        cause: Throwable? = null
    ): DapandaApiRuntimeException {
        return DapandaApiRuntimeException(
            httpStatus = metaInfo.httpStatus,
            result = metaInfo.resultCode,
            errors = errors,
            message = logMessage,
            cause = cause
        )
    }
}