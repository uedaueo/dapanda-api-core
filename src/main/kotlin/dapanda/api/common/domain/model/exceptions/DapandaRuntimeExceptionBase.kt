package dapanda.api.common.domain.model.exceptions

/**
 * 実行時例外の基底クラス。
 *
 * @property message この例外のメッセージです。
 * @property cause この例がが発生する原因となった例外です。
 */
open class DapandaRuntimeExceptionBase(
    override val message: String = "",
    override val cause: Throwable? = null
) : RuntimeException(message, cause)
