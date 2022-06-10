package dapanda.api.common.domain.model.exceptions

import dapanda.api.common.domain.CommonConstants
import io.micronaut.http.HttpStatus

/**
 * dapanda-api-coreがクライアントに返すエラーを返却する例外です。
 */
open class ApiRuntimeException(
    open val httpStatus: HttpStatus,
    open val result: CommonConstants.ResponseResultCode,
    open val errorCode: String,
    open val resultMessage: String,
    open val messageNumber: String,
    override val message: String = "",
    override val cause: Throwable? = null
): DapandaRuntimeExceptionBase(message, cause)