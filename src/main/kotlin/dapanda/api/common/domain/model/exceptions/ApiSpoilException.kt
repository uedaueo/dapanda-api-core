package dapanda.api.common.domain.model.exceptions

import dapanda.api.common.domain.CommonConstants
import io.micronaut.http.HttpStatus

/**
 * クライアントにapiが無効になっているエラーを返却する例外です。
 */
open class ApiSpoilException(
    override val message: String = "",
    override val cause: Throwable? = null
): DapandaRuntimeExceptionBase(message, cause)