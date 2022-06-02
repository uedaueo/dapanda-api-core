package dapanda.api.common.application

import dapanda.api.common.domain.model.http.IApiBase
import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.model.exceptions.DapandaRuntimeException
import dapanda.api.common.domain.model.http.processHeaderInfo
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import javax.validation.Validation

/**
 * Application クラスの共通処理を定義するクラスです。
 */
@Singleton
class ApiBase(
    private val tokenAuthenticate: TokenAuthenticate
) : IApiBase {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <S : RequestHeader, T : ApiTelegram> prepare(httpRequest: HttpCommonRequest<CommonRequest<S, T>>) {
        // バリデーション
        val violations = Validation.buildDefaultValidatorFactory().validator.validate(httpRequest)
        if (violations.isNotEmpty()) {
            for (violation in violations) {
                throw DapandaRuntimeException(
                    property = violation.propertyPath.last().toString(),
                    message = violation.message
                )
            }
        }

        ApiResponseMetaInfoConstants.META001

        // httpRequestにヘッダー情報を設定
        val info = httpRequest.commonRequest!!.info
        httpRequest.processHeaderInfo(info)

        // 認証処理
        tokenAuthenticate.authenticate(httpRequest)
    }

    override fun <S : RequestHeader, T1 : ApiTelegram, T2 : ApiTelegram> finish(
        httpResponse: HttpResponse<CommonResponse<T1>>,
        httpRequest: HttpCommonRequest<CommonRequest<S, T2>>
    ) {
    }

    override fun <S : RequestHeader, T : ApiTelegram> convertJsonToCommonRequest(
        body: String,
        deserializer: BlancoRestGeneratorKtRequestDeserializer<S, T>,
        argHttpRequest: HttpCommonRequest<CommonRequest<S, T>>
    ): CommonRequest<S, T> {
        val mapper = ObjectMapper()
        val module = SimpleModule()
        module.addDeserializer(CommonRequest::class.java, deserializer)
        mapper.registerModule(module)
        val co =
            runCatching {
                mapper.readValue(body, CommonRequest::class.java)
            }
                .onFailure {
                    throw it
                }
                .getOrThrow()

        @Suppress("UNCHECKED_CAST")
        val info = co.info as S

        @Suppress("UNCHECKED_CAST")
        val telegram = co.telegram as T?

        return CommonRequest<S, T>(info, telegram)
    }

    override fun <T : ApiTelegram> createCommonResponse(telegram: T): CommonResponse<T> {
        TODO("Not yet implemented")
    }

    override fun <S : RequestHeader, T : ApiTelegram> createCommonRequest(info: S, telegram: T?): CommonRequest<S, T> {
        TODO("Not yet implemented")
    }
}