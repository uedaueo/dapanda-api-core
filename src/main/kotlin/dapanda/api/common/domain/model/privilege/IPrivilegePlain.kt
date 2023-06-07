package dapanda.api.common.domain.model.privilege

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.privilege.DefaultPrivilege
import dapanda.api.common.application.privilege.DefaultPrivilegePlain
import io.micronaut.context.annotation.DefaultImplementation

/**
 * Interface for privilege issue
 */
@DefaultImplementation(DefaultPrivilegePlain::class)
interface IPrivilegePlain {
    /**
     * test privilege
     *
     * @param request request object.
     * @return true on success.
     */
    fun <T : ApiTelegram> isPermitted(
        request: HttpCommonRequest<T>,
    ): Boolean
}
