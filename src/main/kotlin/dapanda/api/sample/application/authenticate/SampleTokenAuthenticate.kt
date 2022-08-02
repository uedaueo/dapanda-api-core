package dapanda.api.sample.application.authenticate

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.blanco.constants.ApiResponseMetaInfoConstants
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.authenticate.IAuthenticate
import dapanda.api.common.domain.model.exceptions.ApiRuntimeExceptionFactory
import dapanda.api.common.domain.model.http.getToken
import dapanda.api.common.domain.model.locale.LocaleResolver
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.resourcebundle.CommonResourceBundleFactory
import dapanda.api.sample.domain.verifier.ISampleTokenInfoQuery
import dapanda.api.sample.domain.verifier.ISampleTokenInfoRepository
import dapanda.api.sample.domain.verifier.SampleTokenInfo
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * トークン認証を行います。
 */
@Singleton
class SampleTokenAuthenticate(
    private val tokenInfoQuery: ISampleTokenInfoQuery,
    private val tokenInfoRepository: ISampleTokenInfoRepository,
    private val localeResolver: LocaleResolver,
    private val resourceBundle: CommonResourceBundleFactory
): IAuthenticate {
    companion object {
        private val log by LoggerDelegate()
    }

    override fun <S : RequestHeader, T : ApiTelegram> authenticate(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ) {
        val locale = localeResolver.resolve(request)
        if (request.noAuthentication) {
            log.info(resourceBundle.getApiLogMessage(locale).alm006)
            return
        }

        // トークン情報
        val now = nowDateTime()
        val tokenInfo = SampleTokenInfo(
            request.getToken(),
            now,
            now + CommonConstants.LOGIN_TOKEN_VALID_TERM
        )

        // トークン認証を実施する
        var isAuthenticate = false
        if (validToken(tokenInfo)) {
            updateDBToken(tokenInfo)
            isAuthenticate = true
        }

        if (!isAuthenticate) {
            val metaInfo = ApiResponseMetaInfoConstants.META005
            metaInfo.message = resourceBundle.getApiResultMessage(locale).arm005
            val logMessage = resourceBundle.getApiLogMessage(locale).alm005
            throw ApiRuntimeExceptionFactory.create(metaInfo, logMessage)
        }
        log.debug("TokenAuthenticate#authenticate: トークン 認証に成功")
    }

    /**
     * データベースに登録されているトークンを返す
     *
     * @param tokenInfo トークン情報
     * return 認証結果を返す
     */
    private fun validToken(tokenInfo: SampleTokenInfo): Boolean {
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
    private fun updateDBToken(tokenInfo: SampleTokenInfo) {
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