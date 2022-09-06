package dapanda.api.common.application.authorization

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.domain.model.authorization.IAuthorization
import jakarta.inject.Singleton

/**
 * アクセス認可処理を行います。
 */
@Singleton
class DefaultAuthorization: IAuthorization {
    override fun <S : RequestHeader, T : ApiTelegram> authorization(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ) {
    }
}