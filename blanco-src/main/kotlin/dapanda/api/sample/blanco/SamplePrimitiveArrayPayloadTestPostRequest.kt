/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.ApiPostTelegram
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/** POSTメソッドの要求電文 */
@Introspected
@Serdeable
data class SamplePrimitiveArrayPayloadTestPostRequest
constructor(
    /**
     * ユーザーID
     *
     * 規定値 [&quot;&quot;]
     */
    @field:Size(max = 254) @field:NotBlank @field:NotNull var userId: String = "",
    /**
     * パスワード
     *
     * 規定値 [&quot;&quot;]
     */
    @field:Size(max = 254) @field:NotBlank @field:NotNull var password: String = "",
    /** POSTメソッドの要求電文 */
    var argBody: List<String>
) : ApiPostTelegram()
