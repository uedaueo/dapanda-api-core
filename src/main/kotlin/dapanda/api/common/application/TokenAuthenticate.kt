package dapanda.api.common.application

import blanco.restgenerator.valueobject.ApiTelegram
import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.CommonConst
import dapanda.api.common.domain.model.ErrorResponseMessage
import dapanda.api.common.domain.model.exceptions.DapandaRuntimeException
import dapanda.api.common.domain.model.http.getToken
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.common.domain.model.verifier.ITokenInfoQuery
import dapanda.api.common.domain.model.verifier.ITokenInfoRepository
import dapanda.api.common.domain.model.verifier.TokenInfo
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * トークン認証を行います。
 */
@Singleton
class TokenAuthenticate(
    private val tokenInfoQuery: ITokenInfoQuery,
    private val tokenInfoRepository: ITokenInfoRepository
) {
    companion object {
        private val log by LoggerDelegate()
    }

    fun <S : RequestHeader, T : ApiTelegram> authenticate(
        request: HttpCommonRequest<CommonRequest<S, T>>,
    ) {
        if (request.noAuthentication) {
            log.debug("TokenAuthenticate#authenticate: トークン 認証不要")
            return
        }

        // トークン情報
        val now = nowDateTime()
        val tokenInfo = TokenInfo(
            request.getToken(),
            now,
            now + CommonConst.LOGIN_TOKEN_VALID_TERM
        )

        // トークン認証を実施する
        var isAuthenticate = false
        if (validToken(tokenInfo)) {
            updateDBToken(tokenInfo)
            isAuthenticate = true
        }

        if (!isAuthenticate) {
            log.debug("TokenAuthenticate#authenticate: トークン 認証に失敗")
            throw DapandaRuntimeException(
                message = ErrorResponseMessage.faildTokenAuthenticate
            )
        }
        log.debug("TokenAuthenticate#authenticate: トークン 認証に成功")
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
                TimeZone.getDefault().rawOffset / CommonConst.RATIO_MILLISECOND_TO_SECOND
            )
        )
    }
}