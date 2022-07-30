package blanco.restgenerator.valueobject

import io.micronaut.core.annotation.Introspected

/** APIの電文を表すクラスです．全てのRequest, Responseオブジェクトが継承する必要があります． */
@Introspected open class ApiDeleteTelegram : ApiTelegram()
