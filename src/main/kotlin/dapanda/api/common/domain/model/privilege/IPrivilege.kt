package dapanda.api.common.domain.model.privilege

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.privilege.DefaultPrivilege
import io.micronaut.context.annotation.DefaultImplementation

/**
 * Interface for privilege issue
 */
@DefaultImplementation(DefaultPrivilege::class)
interface IPrivilege {
    /**
     * test privilege
     *
     * @param request request object.
     * @return true on success.
     */
    fun <S : RequestHeader, T : ApiTelegram> isPermitted(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ): Boolean
}
