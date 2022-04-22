package dapanda.api.emulator.application

import dapanda.api.emulator.blanco.CheckTokenApiGetRequest
import dapanda.api.emulator.blanco.CheckTokenApiGetResponse
import dapanda.api.emulator.domain.Const
import dapanda.api.common.application.ApiBase
import dapanda.api.common.domain.model.http.IApiBase
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.CommonResponse
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import jakarta.inject.Singleton
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

@Singleton
class CheckTokenApiManagement(
    private val apiBase: ApiBase,
) : IApiBase by apiBase {
    companion object {
        private val log: Log = LogFactory.getLog(CheckTokenApiManagement::class.java)
    }

    fun doGet(
        httpRequest: HttpCommonRequest<CommonRequest<RequestHeader, CheckTokenApiGetRequest>>
    ): HttpResponse<CommonResponse<CheckTokenApiGetResponse>> {
        val telegram: CheckTokenApiGetRequest = httpRequest.commonRequest?.telegram ?: return HttpResponse.serverError()
        if (telegram.token == Const.OK_TOKEN) {
            return HttpResponse.ok()
        } else if (telegram.token == Const.NG_TOKEN) {
            return HttpResponse.status(HttpStatus.FORBIDDEN)
        } else {
            log.error("Failed to check token")
            return HttpResponse.status(HttpStatus.FORBIDDEN)
        }
    }
}