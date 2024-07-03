/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.ApiPostTelegram
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/** POSTメソッドの要求電文 */
@Introspected
@Serdeable
data class SampleArrayPayloadTestPostRequest
constructor(
    /**
     * ユーザーID
     *
     * 規定値 [&quot;&quot;]
     */
    @field:Size(max = 254) @field:NotBlank @field:NotNull var userId: String = ""
) : ApiPostTelegram() {
  /**
   * POSTメソッドの要求電文
   *
   * 規定値 [mutableListOf()]
   */
  var arrayBody: List<SampleArrayPayloadTestPostRequestBody>? = mutableListOf()
}
