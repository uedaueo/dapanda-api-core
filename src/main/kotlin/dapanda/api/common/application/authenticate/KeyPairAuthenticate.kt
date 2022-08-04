package dapanda.api.common.application.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.context.annotation.Replaces
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.core.util.StringUtils
import jakarta.inject.Singleton



@Singleton
@Requirements(
    Requires(property = "keypair-authenticate.enabled", value = StringUtils.TRUE),
)
@Replaces(TokenAuthenticate::class)
class KeyPairAuthenticate: IAuthenticate {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <S : RequestHeader, T : ApiTelegram> authenticate(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ) {
        println("KeyPairAuthenticate:::KeyPairAuthenticate!!!!!!!")
    }
}