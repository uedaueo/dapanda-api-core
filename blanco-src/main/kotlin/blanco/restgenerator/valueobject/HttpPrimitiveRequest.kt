package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.http.HttpRequest
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

/** Body に Primitive を持つ場合の共通リクエストを表すオブジェクトです。 */
@Introspected
@Serdeable
data class HttpPrimitiveRequest<T, B>
constructor(
    /**
     * micronautが用意しているHttpRequest
     *
     * フィールド: [delegate]。
     */
    @NotNull @field:Valid @Nullable val delegate: HttpRequest<T>,
    /**
     * 認証が不要なAPIであればtrue
     *
     * フィールド: [noAuthentication]。 デフォルト: [false]。
     */
    @Nullable val noAuthentication: Boolean = false,
    /**
     * メタID情報（文字列）のリスト
     *
     * フィールド: [metaIdList]。
     */
    @field:Valid @Nullable val metaIdList: List<String>?,
    /**
     * blancoRestGeneratorの独自のCommonRequest
     *
     * フィールド: [commonRequest]。
     */
    @NotNull @field:Valid @Nullable var commonRequest: T?,
    /**
     * body に載せられた Primitive またはその配列
     *
     * フィールド: [primitiveRequest]。
     */
    @field:Valid @Nullable var primitiveRequest: B?
) : HttpRequest<T> by delegate {
  /**
   * IPアドレス認証等、補助的な認証も不要なAPIであればtrue
   *
   * フィールド: [noAuxiliaryAuthentication]。 デフォルト: [false]。
   */
  @Nullable var noAuxiliaryAuthentication: Boolean = false

  /**
   * 生のbodyデータを格納します。
   *
   * フィールド: [rawBody]。 デフォルト: [null]。
   */
  @Nullable var rawBody: String? = null
}
