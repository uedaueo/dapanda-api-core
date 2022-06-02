package dapanda.api.common.domain.model.resourcebundle

import dapanda.api.common.blanco.resourcebundle.ApiLogMessageResourceBundle
import dapanda.api.common.blanco.resourcebundle.ApiResultMessageResourceBundle
import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Singleton
import java.util.*

@Singleton
open class CommonResourceBundleFactory {
    /**
     * API返却メッセージ用リソースバンドル取得
     *
     * @param locale ロケール
     * @return リソースバンドルを返す。
     */
    @Cacheable("api-result-resource-bundle")
    open fun getApiResultMessage(locale: Locale = Locale.getDefault()): ApiResultMessageResourceBundle =
        ApiResultMessageResourceBundle(locale)

    /**
     * APIログメッセージ用リソースバンドル取得
     *
     * @param locale ロケール
     * @return リソースバンドルを返す。
     */
    @Cacheable("api-log-resource-bundle")
    open fun getApiLogMessage(locale: Locale = Locale.getDefault()): ApiLogMessageResourceBundle =
        ApiLogMessageResourceBundle(locale)
}