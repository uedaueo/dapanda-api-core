package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** APIの電文を表すクラスです．全てのRequest, Responseオブジェクトが継承する必要があります． */
@Introspected
open class ApiTelegram {
  /**
   * 電文クラス名を文字列として返却します。各電文クラス実装でオーバーライドされることを期待しています。
   *
   * フィールド: [telegramId]。 デフォルト: [&quot;&quot;]。
   */
  var telegramId: String = ""
}
