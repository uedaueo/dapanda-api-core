/*
 * This source code has been generated by blanco Framework.
 */
package dapanda.api.sample.blanco

import blanco.restgenerator.valueobject.ApiGetTelegram
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

/** GETメソッドの応答電文 */
@Serdeable
@Introspected
data class SampleArrayPayloadTestGetResponse
constructor(
    /** ユーザ名っぽい何か */
    @Nullable var name: String,
    /** 年齢っぽい何か */
    @Nullable var age: Long
) : ApiGetTelegram()
