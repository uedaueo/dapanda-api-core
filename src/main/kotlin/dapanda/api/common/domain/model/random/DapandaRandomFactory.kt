package dapanda.api.common.domain.model.random

import dapanda.api.common.domain.CommonConstants
import dapanda.api.common.domain.model.logging.LoggerDelegate
import io.micronaut.context.annotation.Value
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.security.SecureRandom

@Singleton
class DapandaRandomFactory(
    @Value("\${dapanda.random.algorithm:" + CommonConstants.RANDOM_ALGORITHM_NATIVE_PRNG +  "}")
    val algorithm: String
) : IDapandaRandomFactory {

    companion object {
        private val log by LoggerDelegate()
    }

    override fun getSecureRandom(): SecureRandom {
        log.debug("%%% Random algorithm = " + this.algorithm)
        var rand: SecureRandom
        if (this.algorithm != CommonConstants.RANDOM_ALGORITHM_NATIVE_PRNG &&
            this.algorithm != CommonConstants.RANDOM_ALGORITHM_NATIVE_PRNG_BLOCKING &&
            this.algorithm != CommonConstants.RANDOM_ALGORITHM_NATIVE_PRNG_NON_BLOCKING
            ) {
            rand = SecureRandom.getInstanceStrong()
        } else {
            rand = SecureRandom.getInstance(this.algorithm)
        }
        return rand
    }
}
