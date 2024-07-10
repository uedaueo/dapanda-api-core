/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.ApiPutTelegram
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/** ログアウトAPIの要求電文 */
@Introspected
@Serdeable
data class SampleLogoutPutRequest
constructor(
    /**
     * ユーザーID
     *
     * 規定値 [&quot;&quot;]
     */
    @field:Size(max = 254) @field:NotBlank @field:NotNull var userId: String = ""
) : ApiPutTelegram()
