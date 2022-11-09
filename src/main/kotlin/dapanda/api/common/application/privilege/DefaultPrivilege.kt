package dapanda.api.common.application.privilege

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.model.privilege.IPrivilege
import jakarta.inject.Singleton

/**
 * 権限処理を行います。
 */
@Singleton
class DefaultPrivilege: IPrivilege {
    override fun <S : RequestHeader, T : ApiTelegram> isPermitted(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ): Boolean {
        return true;
    }
}
