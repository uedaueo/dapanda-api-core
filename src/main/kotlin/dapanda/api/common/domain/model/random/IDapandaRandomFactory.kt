package dapanda.api.common.domain.model.random

import dapanda.api.common.application.privilege.DefaultPrivilege
import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.context.annotation.DefaultImplementation
import io.micronaut.context.annotation.Value
import jakarta.inject.Singleton
import java.security.SecureRandom

@DefaultImplementation(DapandaRandomFactory::class)
interface IDapandaRandomFactory {
    fun getSecureRandom(): SecureRandom
}
