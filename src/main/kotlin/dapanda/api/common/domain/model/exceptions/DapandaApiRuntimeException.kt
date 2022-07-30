package dapanda.api.common.domain.model.exceptions

import blanco.restgenerator.valueobject.MessageItem
import dapanda.api.common.domain.CommonConstants
import io.micronaut.http.HttpStatus

class DapandaApiRuntimeException(
    val httpStatus: HttpStatus,
    val result: CommonConstants.ResponseResultCode,
    val errors: ArrayList<MessageItem>,
    override val message: String = "",
    override val cause: Throwable? = null
): DapandaRuntimeExceptionBase(message, cause)