package dapanda.api.common.domain.model.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.authenticate.TokenAuthenticate
import io.micronaut.context.annotation.DefaultImplementation

/**
 * Interface for Authentication issue.
 */
@DefaultImplementation(TokenAuthenticate::class)
interface IAuthenticatePlain {
    /**
     * test authentication.
     *
     * @param request request object as plain style
     * @return true on success
     */
    fun <T : ApiTelegram> isAuthenticated(
        request: HttpCommonRequest<T>
    ): Boolean
}
