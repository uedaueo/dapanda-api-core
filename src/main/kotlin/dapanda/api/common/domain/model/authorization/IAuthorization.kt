package dapanda.api.common.domain.model.authorization

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.authorization.DefaultAuthorization
import io.micronaut.context.annotation.DefaultImplementation

@DefaultImplementation(DefaultAuthorization::class)
interface IAuthorization {
    fun <S : RequestHeader, T : ApiTelegram> authorization(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    )
}