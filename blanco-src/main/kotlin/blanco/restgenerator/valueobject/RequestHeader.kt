package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** 通信に関するメタ情報を表す型です */
@Introspected
open class RequestHeader {
  /**
   * トークン認証に使うトークン文字列
   *
   * フィールド: [token]。 デフォルト: [null]。
   */
  var token: String? = null

  /**
   * 言語コード
   *
   * フィールド: [lang]。 デフォルト: [null]。
   */
  var lang: String? = null
}
