package dapanda.api.common.application

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonResponse
import dapanda.api.common.domain.model.exceptions.DapandaRuntimeException
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
        return if (e is DapandaRuntimeException) {
            log.error(e.message, e)
            HttpResponse.status<CommonResponse<ApiTelegram>>(HttpStatus.BAD_REQUEST).body(
                CommonResponse<ApiTelegram>(
                    property = e.property,
                    message = e.message
                )
            )
        } else {
            log.error(e.message, e)
            HttpResponse.status<CommonResponse<ApiTelegram>>(HttpStatus.INTERNAL_SERVER_ERROR).body(
                CommonResponse<ApiTelegram>(
                    message = e.message
                )
            )
        }
    }
}