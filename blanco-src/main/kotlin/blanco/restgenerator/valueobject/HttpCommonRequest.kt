package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpRequest
import io.micronaut.serde.annotation.Serdeable
import javax.validation.Valid
import javax.validation.constraints.NotNull

/** 共通リクエストを表すオブジェクトです。 */
@Introspected
@Serdeable
data class HttpCommonRequest<T>
constructor(
    /**
     * micronautが用意しているHttpRequest
     *
     * フィールド: [delegate]。
     */
    @NotNull @field:Valid val delegate: HttpRequest<T>,
    /**
     * 認証が不要なAPIであればtrue
     *
     * フィールド: [noAuthentication]。 デフォルト: [false]。
     */
    val noAuthentication: Boolean = false,
    /**
     * メタID情報（文字列）のリスト
     *
     * フィールド: [metaIdList]。
     */
    @field:Valid val metaIdList: List<String>?,
    /**
     * blancoRestGeneratorの独自のCommonRequest
     *
     * フィールド: [commonRequest]。
     */
    @NotNull @field:Valid var commonRequest: T?
) : HttpRequest<T> by delegate {
  /**
   * IPアドレス認証等、補助的な認証も不要なAPIであればtrue
   *
   * フィールド: [noAuxiliaryAuthentication]。 デフォルト: [false]。
   */
  var noAuxiliaryAuthentication: Boolean = false
}
