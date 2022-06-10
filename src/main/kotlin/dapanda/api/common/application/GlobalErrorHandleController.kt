package dapanda.api.common.application

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonResponse
import dapanda.api.common.domain.model.exceptions.ApiRuntimeException
import dapanda.api.common.domain.model.exceptions.DapandaApiRuntimeException
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error

/**
 * グローバルエラーハンドラーコントローラー
 */
@Requires(property = "globalErrorHandler.enabled", value = "true")
@Controller
class GlobalErrorHandleController {
    companion object {
        /** ロガー */
        private val log by LoggerDelegate()
    }

    /**
     * Throwable ハンドラ
     *
     * @param request HTTP リクエスト
     * @param e Throwable
     * @return HTTP レスポンスを返す。
     */
    @Error(global = true)
    fun globalErrorHandler(request: HttpRequest<*>, e: Throwable): HttpResponse<*> {
        return if (e is ApiRuntimeException) {
            // API 例外
            log.error(e.message, e)
            if (log.isDebugEnabled) {
                log.debug("accept: ${request.headers.accept()}")
            }

            if (request.headers.accept().isEmpty()) {
                log.info("Accept ヘッダが設定されていません。$request")
            }
            // response を生成
            CommonHttpResponseFactory.create(
                result = e.result.code.toLong(),
                errorCode = e.errorCode,
                messageNumber = e.messageNumber,
                message = e.resultMessage,
                httpStatus = e.httpStatus
            )
        } else if (e is DapandaApiRuntimeException) {
            // API 例外
            log.error(e.message, e)
            if (log.isDebugEnabled) {
                log.debug("accept: ${request.headers.accept()}")
            }

            if (request.headers.accept().isEmpty()) {
                log.info("Accept ヘッダが設定されていません。$request")
            }

            // response を生成
            CommonHttpResponseFactory.create(
                result = e.result.code.toLong(),
                errors = e.errors,
                httpStatus = e.httpStatus
            )
        }
        else {
            // 想定外の例外の場合
            throw e
        }
    }
}