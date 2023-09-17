package dapanda.api.common.application

import blanco.restgenerator.valueobject.*
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.authenticate.IAuthenticatePlain
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.http.IApiBasePlain
import dapanda.api.common.domain.model.http.setRequestHeaderLocale
import dapanda.api.common.domain.model.http.setStartTime
import dapanda.api.common.domain.model.locale.LocaleResolverPlain
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.privilege.IPrivilegePlain
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import jakarta.inject.Singleton
import javax.validation.Validation

/**
 * Application クラスの共通処理を定義するクラスです。
 */
@Singleton
class ApiBasePlain(
    private val bundleFactory: CommonResourceBundleFactory,
    private val localeResolverPlain: LocaleResolverPlain,
    private val authenticate: IAuthenticatePlain,
    @Value("\${authenticate.required}")
    private val doAuthenticate: Boolean,
    private val privilegePlain: IPrivilegePlain,
    @Value("\${privilege.required}")
    private val testPrivilege: Boolean
) : IApiBasePlain {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <T : ApiTelegram> prepare(
        httpRequest: HttpCommonRequest<T>
    ) {
        /*
         * 計測開始
         */
        httpRequest.setStartTime()
        log.debug("ApiBase#prepare: START!")

        // requestに設定されているLocaleを取得
        httpRequest.let {
            val blancoLocale = Locale()
            it.headers.getFirst(CommonConstants.X_DAPANDA_LANGUAGE).let {
                if (it.isPresent) {
                    blancoLocale.lang = it.get()
                }
            }
            it.headers.getFirst(CommonConstants.X_DAPANDA_TIMEZONE).let {
                if (it.isPresent) {
                    blancoLocale.tz = it.get()
                }
            }
            it.headers.getFirst(CommonConstants.X_DAPANDA_CURRENCY).let {
                if (it.isPresent) {
                    blancoLocale.currency = it.get()
                }
            }
            log.debug("Locale = " + blancoLocale.toString())
            it.setRequestHeaderLocale(blancoLocale)
        }

        // ロケールを取得
        val locale = localeResolverPlain.resolve(httpRequest)

        // バリデーション
        val violations = Validation.buildDefaultValidatorFactory().validator.validate(httpRequest)
        if (violations.isNotEmpty()) {
            var msg = ""
            val ite = violations.iterator()
            while (ite.hasNext()) {
                msg += "[ " + ite.next().message + " ] "
            }
            val metaInfo = ApiResponseMetaInfoConstants.META90006
            metaInfo.message = bundleFactory.getApiResultMessage(locale = locale).getArm90006(msg)
            log.debug("message : " + metaInfo.message)
//            log.debug("messageNumber : " + metaInfo.messageNumber)
            throw ApiRuntimeExceptionFactory.create(
                metaInfo = metaInfo,
                logMessage = violations.joinToString(", ")
            )
        }

        // 認証処理
        if (doAuthenticate) {
            if (!authenticate.isAuthenticated(httpRequest)) {
                val metaInfo = ApiResponseMetaInfoConstants.META90009
                metaInfo.message = bundleFactory.getApiResultMessage(locale = locale).arm90009
                val logMessage = bundleFactory.getApiLogMessage(locale = locale).alm90009
                throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
            }
        } else {
            log.debug("認証処理は無効です")
        }

        // 権限処理
        if (testPrivilege) {
            if (!privilegePlain.isPermitted(httpRequest)) {
                val metaInfo = ApiResponseMetaInfoConstants.META90010
                metaInfo.message = bundleFactory.getApiResultMessage(locale = locale).arm90010
                val logMessage = bundleFactory.getApiLogMessage(locale = locale).alm90010
                throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
            }
        } else {
            log.debug("認可処理は無効です")
        }
    }

    override fun <T1 : ApiTelegram, T2 : ApiTelegram> finish(
        httpResponse: HttpResponse<T1>,
        httpRequest: HttpCommonRequest<T2>
    ) {
    }

    override fun <T1 : ApiTelegram, T2 : ApiTelegram> finishArray(
        httpResponse: HttpResponse<List<T1>>,
        httpRequest: HttpCommonRequest<T2>
    ) {
    }

    override fun isSpoiled(method: String): Boolean {
        return false
    }
}
