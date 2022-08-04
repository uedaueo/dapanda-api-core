package dapanda.api.common.domain.model.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.authenticate.TokenAuthenticate
import io.micronaut.context.annotation.DefaultImplementation

@DefaultImplementation(TokenAuthenticate::class)
interface IAuthenticate {
    fun <S : RequestHeader, T : ApiTelegram> authenticate(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    )
}