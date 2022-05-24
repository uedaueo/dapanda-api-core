package dapanda.api.common.domain.model.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

/**
 * ロガー取得
 *
 * @param forClass クラス
 * @return ロガーを返す。
 */
private fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)

/**
 * ロギング対象クラスを取得
 *
 * @param T クラス
 * @param javaClass クラス
 * @return ロギング対象クラスを返す。
 */
@Suppress("NOTHING_TO_INLINE")
private inline fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        // コンパニオンクラスの場合は、その包含クラスをロギング対象とする
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}

/**
 * ロガー取得委譲
 *
 * @param R このクラスを参照しているクラス
 */
class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
    override fun getValue(thisRef: R, property: KProperty<*>): Logger =
        getLogger(
            getClassForLogging(
                thisRef.javaClass
            )
        )
}