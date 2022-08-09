package dapanda.api.common.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.exceptions.ApiRuntimeException
import dapanda.api.common.domain.model.exceptions.DapandaApiRuntimeException
import dapanda.api.common.domain.model.http.CommonHttpResponseFactory
import dapanda.api.common.domain.model.http.getRequestHeaderLocale
import dapanda.api.common.domain.model.http.getStartTime
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.sample.blanco.SampleLoginPostRequest
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
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
        var locale = request.getRequestHeaderLocale()

        return if (e is ApiRuntimeException) {
            // API 例外
            if (request.headers.accept().isEmpty()) {
                log.info("Accept ヘッダが設定されていません。$request")
            }
            // response を生成
            val info = ResponseHeader(
                locale = locale,
                time = Utilities.getMeasurementTime(request.getStartTime()),
                result = e.result.name
            )
            CommonHttpResponseFactory.create(
                info = info,
                errorCode = e.errorCode,
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
            val info = ResponseHeader(
                locale = locale,
                time = Utilities.getMeasurementTime(request.getStartTime()),
                result = e.result.name
            )
            CommonHttpResponseFactory.create(
                info = info,
                errors = e.errors,
                httpStatus = e.httpStatus
            )
        } else {
            // 想定外の例外の場合
            throw e
        }
    }
}