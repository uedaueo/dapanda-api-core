package dapanda.api.common.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.common.Utilities
import dapanda.api.common.domain.model.exceptions.ApiRuntimeException
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionPlain
import dapanda.api.common.domain.model.exceptions.ApiSpoilException
import dapanda.api.common.domain.model.exceptions.DapandaApiRuntimeException
import dapanda.api.common.domain.model.http.CommonHttpResponsePlainFactory
import dapanda.api.common.domain.model.http.getRequestHeaderLocale
import dapanda.api.common.domain.model.http.getStartTime
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.core.util.StringUtils
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import java.net.URISyntaxException

/**
 * グローバルエラーハンドラーコントローラー
 */
@Requirements(
    Requires(property = "plain-telegram.enabled", value = StringUtils.TRUE),
    Requires(property = "globalErrorHandler.enabled", value = StringUtils.TRUE)
)
@Controller
class GlobalErrorHandlePlainController(
    private val bundleFactory: CommonResourceBundleFactory
) {
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
        val locale = request.getRequestHeaderLocale()
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
            val info = ResponseHeader(
                locale = locale,
                time = Utilities.getMeasurementTime(request.getStartTime()),
                result = e.result.name
            )
            CommonHttpResponsePlainFactory.create(
                errorCode = e.errorCode,
                message = e.resultMessage,
                httpStatus = e.httpStatus,
                request = request
            )
        } else if (e is ApiRuntimeExceptionPlain) {
            // API 例外
            log.error(e.message, e)

            CommonHttpResponsePlainFactory.create(
                httpStatus = e.httpStatus,
                telegram = e.telegram,
                request = request
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
            CommonHttpResponsePlainFactory.create(
                errors = e.errors,
                httpStatus = e.httpStatus,
                request = request
            )
        } else if (e is ApiSpoilException) {
            // response を生成
            val metaInfo = ApiResponseMetaInfoConstants.META90007
            CommonHttpResponsePlainFactory.create(
                errorCode = metaInfo.errorCode,
                message = bundleFactory.getApiResultMessage().arm90007,
                httpStatus = metaInfo.httpStatus,
                request = request
            )
        } else if (e is RuntimeException || e is URISyntaxException) {
            log.error(e.message, e)
            val metaInfo = ApiResponseMetaInfoConstants.META99999
            // response を生成
            CommonHttpResponsePlainFactory.create(
                errorCode = metaInfo.errorCode,
                message = metaInfo.message,
                httpStatus = metaInfo.httpStatus,
                request = request
            )
        }  else {
            // 想定外の例外の場合
            throw e
        }
    }
}
