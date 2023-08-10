package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

/** APIの電文を表すクラスです．全てのRequest, Responseオブジェクトが継承する必要があります． */
@Introspected @Serdeable open class ApiGetTelegram : ApiTelegram()
