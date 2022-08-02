package dapanda.api.sample.application.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import dapanda.api.common.domain.model.logging.LoggerDelegate
import jakarta.inject.Singleton

@Singleton
class SampleKeyPairAuthenticate: IAuthenticate {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <S : RequestHeader, T : ApiTelegram> authenticate(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ) {
        println("KeyPairAuthenticate:::KeyPairAuthenticate!!!!!!!")
    }
}