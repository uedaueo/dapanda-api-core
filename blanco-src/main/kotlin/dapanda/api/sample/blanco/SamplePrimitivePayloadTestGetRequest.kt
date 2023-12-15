/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.ApiGetTelegram
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/** GETメソッドの要求電文 */
@Introspected
@Serdeable
data class SamplePrimitivePayloadTestGetRequest
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
    @field:Size(max = 50)
    @field:NotBlank
    @field:Pattern(
        regexp =
            "^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[A-Z])(?=.*[@%\\+\\/\\\'!#\\$\\^\\?:\\.\\(\\)\\{\\}\\[\\]~\\-_])|(?=.*[a-z])(?=.*[0-9])(?=.*[@%\\+\\/\\\'!#\\$\\^\\?:\\.\\(\\)\\{\\}\\[\\]~\\-_])|(?=.*[A-Z])(?=.*[0-9])(?=.*[@%\\+\\/\\\'!#\\$\\^\\?:\\.\\(\\)\\{\\}\\[\\]~\\-_]))[a-zA-Z0-9@%\\+\\/\\\'!#\\$\\^\\?:\\.\\(\\)\\{\\}\\[\\]~\\-_]{8,20}$")
    @field:NotNull
    var password: String? = ""
) : ApiGetTelegram()
