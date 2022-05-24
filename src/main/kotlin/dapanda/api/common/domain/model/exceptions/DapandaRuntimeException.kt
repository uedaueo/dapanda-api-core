package dapanda.api.common.domain.model.exceptions

/**
 * dapanda-api-coreがクライアントに返すエラーを返却する例外です。
 */
class DapandaRuntimeException(
    val property: String = "",
    override val message: String = "",
    override val cause: Throwable? = null
): RuntimeException(message, cause)