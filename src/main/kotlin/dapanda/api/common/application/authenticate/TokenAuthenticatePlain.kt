package dapanda.api.common.application.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import dapanda.api.common.domain.model.authenticate.IAuthenticatePlain
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.http.getBearerToken
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.locale.LocaleResolverPlain
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.common.domain.model.verifier.ITokenInfoQuery
import dapanda.api.common.domain.model.verifier.ITokenInfoRepository
import dapanda.api.common.domain.model.verifier.TokenInfo
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import io.micronaut.core.util.StringUtils
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * トークン認証を行います。
 */
@Requirements(
    Requires(property = "keypair-authenticate.enabled", value = StringUtils.FALSE),
)
@Singleton
class TokenAuthenticatePlain(
    private val bundleFactory: CommonResourceBundleFactory,
    private val tokenInfoQuery: ITokenInfoQuery,
    private val tokenInfoRepository: ITokenInfoRepository,
    private val localeResolverPlain: LocaleResolverPlain,
    private val resourceBundle: CommonResourceBundleFactory,
    @Value("\${token-authenticate.token-valid-term}")
    private val tokenValidTerm: Int
): IAuthenticatePlain {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <T : ApiTelegram> isAuthenticated(
        request: HttpCommonRequest<T>,
    ): Boolean {
        val locale = localeResolverPlain.resolve(request)
        if (request.noAuthentication) {
            log.info(resourceBundle.getApiLogMessage(locale).alm90006)
            return true
        }

        // トークン情報
        val token = request.getBearerToken()
        if (token.isNullOrBlank()) {
            val metaInfo = ApiResponseMetaInfoConstants.META90005
            metaInfo.message = bundleFactory.getApiResultMessage(locale = locale).arm90005
            throw ApiRuntimeExceptionFactory.create(
                metaInfo = metaInfo,
                logMessage = "HttpHeaderにtokenが設定されていません。"
            )
        }
        val now = nowDateTime()
        val tokenInfo = TokenInfo(
            token,
            now,
            now + tokenValidTerm
        )

        // トークン認証を実施する
        var isAuthenticated = false
        if (validToken(tokenInfo)) {
            updateDBToken(tokenInfo)
            isAuthenticated = true
        }

        if (!isAuthenticated) {
            val metaInfo = ApiResponseMetaInfoConstants.META90005
            metaInfo.message = resourceBundle.getApiResultMessage(locale).arm90005
            val logMessage = resourceBundle.getApiLogMessage(locale).alm90005
            throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
        }
        log.debug("TokenAuthenticate#authenticate: トークン 認証に成功")
        return true
    }

    /**
     * データベースに登録されているトークンを返す
     *
     * @param tokenInfo トークン情報
     * return 認証結果を返す
     */
    private fun validToken(tokenInfo: TokenInfo): Boolean {
        return runCatching {
            var result  = false
            val row = tokenInfoQuery.getValidTokenInfo(tokenInfo.token, tokenInfo.nowDateTime)
            if (row != null) {
                result = true
            }
            result
        }
            .onFailure { throwable ->
                throw throwable
            }
            .getOrThrow()
    }

    /**
     *データベースに登録されているトークンの有効期限を更新する
     *
     * @param tokenInfo トークン情報
     */
    private fun updateDBToken(tokenInfo: TokenInfo) {
        runCatching {
            tokenInfoRepository.updateTokenExpired(tokenInfo.token, tokenInfo.expiredDateTime)
        }
            .onFailure { throwable ->
                throw throwable
            }
            .getOrThrow()
    }

    /**
     * 現在の日時を返す
     */
    private fun nowDateTime(): Long {
        return LocalDateTime.now().toEpochSecond(
            ZoneOffset.ofTotalSeconds(
                TimeZone.getDefault().rawOffset / CommonConstants.RATIO_MILLISECOND_TO_SECOND
            )
        )
    }
}
