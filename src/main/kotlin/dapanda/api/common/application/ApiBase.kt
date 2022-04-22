package dapanda.api.common.application

import dapanda.api.common.domain.model.http.IApiBase
import blanco.restgenerator.util.BlancoRestGeneratorKtRequestDeserializer
import blanco.restgenerator.valueobject.*
import io.micronaut.http.HttpResponse
import io.micronaut.validation.validator.Validator
import jakarta.inject.Singleton
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

@Singleton
class ApiBase(
    private val validator: Validator
) : IApiBase {
    companion object {
        private val log: Log = LogFactory.getLog(ApiBase::class.java)
    }
    override fun <S : RequestHeader, T : ApiTelegram> prepare(httpRequest: HttpCommonRequest<CommonRequest<S, T>>) {
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
        TODO("Not yet implemented")
    }

    override fun <T : ApiTelegram> createCommonResponse(telegram: T): CommonResponse<T> {
        TODO("Not yet implemented")
    }

    override fun <S : RequestHeader, T : ApiTelegram> createCommonRequest(info: S, telegram: T?): CommonRequest<S, T> {
        TODO("Not yet implemented")
    }
}