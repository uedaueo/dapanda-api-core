package dapanda.api.common.domain.model.locale

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import com.fasterxml.jackson.databind.ObjectMapper
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import io.micronaut.http.HttpMethod
import io.micronaut.http.HttpRequest
import jakarta.inject.Singleton
import java.util.*

/**
 * ロケール解決
 *
 * @property objectMapper オブジェクトマッパー
 * @property bundleFactory リソースバンドルファクトリ
 */
@Singleton
class LocaleResolverPlain(
    private val objectMapper: ObjectMapper,
    private val bundleFactory: CommonResourceBundleFactory
) {
    companion object {
        /** ロガー */
        private val log by LoggerDelegate()

        /**
         * ロケールをリクエスト属性に格納するキー
         */
        private const val LOCALE_CACHE = "####COMMON_LOCALE_CACHE####"
    }

    fun <T : ApiTelegram> resolve(request: HttpCommonRequest<T>): Locale {
        return if (request.attributes.contains(LOCALE_CACHE)) {
            // リクエスト属性に Locale のキャッシュがあった場合
            request.attributes.get(LOCALE_CACHE, Locale::class.java)
                .orElse(Locale.getDefault())
        } else {
            var localeString: String? = "ja"
            runCatching<Locale> {
                if (request.method == HttpMethod.POST || request.method == HttpMethod.PUT) {
                    // POST または PUT の場合
                    // TODO ACCEPT-LANGUAGE HTTP ヘッダー からlocaleを取得する? とりあえずデフォルト値(ja)を入れる
                    Locale.forLanguageTag(localeString)
                } else {
                    getHeaderLocale(request)
                }
            }
                .onFailure {
                    log.info(
                        // リクエストパラメータに不正な値が設定されています。項目：{0}, 設定値：{1}
                        bundleFactory.getApiLogMessage().getAlm90001("info.lang", localeString)
                    )
                }
                .getOrDefault(getHeaderLocale(request))
                .also { locale ->
                    // 取得したロケールをリクエスト属性にキャッシュとして格納
                    request.attributes.put(LOCALE_CACHE, locale)
                }
        }
    }

    /**
     * ヘッダ（Accept-Language）からロケールを取得する
     *
     * ヘッダ（Accept-Language）が無い場合、システムデフォルトのロケールを返す。
     *
     * @param request HTTP リクエスト
     * @return ロケールを返す。
     */
    private fun getHeaderLocale(request: HttpRequest<*>): Locale = request.locale.orElse(Locale.getDefault())
}