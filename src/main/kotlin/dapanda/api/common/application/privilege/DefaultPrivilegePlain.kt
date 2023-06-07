package dapanda.api.common.application.privilege

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.model.privilege.IPrivilege
import dapanda.api.common.domain.model.privilege.IPrivilegePlain
import jakarta.inject.Singleton

/**
 * 権限処理を行います。
 */
@Singleton
class DefaultPrivilegePlain: IPrivilegePlain {
    override fun <T : ApiTelegram> isPermitted(
        request: HttpCommonRequest<T>,
    ): Boolean {
        return true;
    }
}
