package dapanda.api.common.domain.model.exceptions

import blanco.restgenerator.valueobject.ApiTelegram
import dapanda.api.common.domain.CommonConstants
import io.micronaut.http.HttpStatus

/**
 * dapanda-api-coreがクライアントに返すエラーを返却する例外です。
 */
open class ApiRuntimeExceptionPlain(
    open val httpStatus: HttpStatus,
    open val telegram: ApiTelegram,
): RuntimeException()