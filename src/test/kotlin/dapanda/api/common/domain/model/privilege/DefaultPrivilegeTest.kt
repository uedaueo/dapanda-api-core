package dapanda.api.common.domain.model.privilege

import blanco.restgenerator.valueobject.CommonRequest
import blanco.restgenerator.valueobject.HttpCommonRequest
import blanco.restgenerator.valueobject.RequestHeader
import dapanda.api.common.application.privilege.DefaultPrivilege
import dapanda.api.common.domain.model.logging.LoggerDelegate
import dapanda.api.sample.blanco.SampleLoginPostRequest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class DefaultPrivilegeTest() : StringSpec({

    val privilege: DefaultPrivilege = DefaultPrivilege()

    "DefaultPrivilegeは常にtrue" {
        val httpRequest = HttpCommonRequest<CommonRequest<RequestHeader, SampleLoginPostRequest>>(
            HttpRequest.POST(
                "DefaultPrivilegeTest",
                CommonRequest(RequestHeader(), SampleLoginPostRequest()),
            ),
            false,
            null,
            CommonRequest(RequestHeader(), SampleLoginPostRequest())
        )
        privilege.isPermitted(httpRequest) shouldBe true
    }
})

