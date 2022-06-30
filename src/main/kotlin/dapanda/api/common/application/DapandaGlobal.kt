package dapanda.api.common.application

import dapanda.api.common.domain.model.logging.LoggerDelegate
import jakarta.inject.Singleton
import java.nio.ByteBuffer
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.*


@Singleton
class DapandaGlobal {
    companion object {
        val randomNativePRNGBlocking: SecureRandom = SecureRandom.getInstance("NativePRNGBlocking")
        val randomNativePRNGNonBlocking: SecureRandom = SecureRandom.getInstance("NativePRNGNonBlocking")
    }
}