package dapanda.api.common.domain.model.random

import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class DapandaRandomFactoryTest(
    private val randomFactory: IDapandaRandomFactory
) {
    @Test
    fun testSecureRandom() {
       val rand = randomFactory.getSecureRandom()
       println("rand = " + rand.algorithm)
       true shouldBe true
    }
}
