package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

/** APIの電文を表すクラスです．全てのRequest, Responseオブジェクトが継承する必要があります． */
@Introspected
@Serdeable
open class ApiTelegram {
  /**
   * 画面APIの権限を設定します。各電文クラスでオーバーライドされる前提です。
   *
   * フィールド: [permissionKind]。 デフォルト: [&quot;&quot;]。
   */
  @Nullable open val permissionKind: String = ""
}
