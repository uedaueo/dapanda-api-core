package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** 通信に関するメタ情報を表す型です */
@Introspected
open class RequestHeader {
  /** フィールド: [token]。 デフォルト: [null]。 */
  var token: String? = null

  /** フィールド: [lang]。 デフォルト: [null]。 */
  var lang: String? = null
}
