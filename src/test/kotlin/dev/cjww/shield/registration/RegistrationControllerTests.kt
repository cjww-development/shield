/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RegistrationControllerTests {
    @Test
    fun `given a valid request, create user should respond with a 200 response`() {
        val testController =
            RegistrationController(
                registrationInteractor = RegistrationInteractorSpy(),
            )

        val testRequest: Request =
            Request(
                emailAddress = "test@email.com",
                password = "testPassword",
            )

        val result: Response = testController.createUser(testRequest)

        result.message.shouldBe("Created new user")
        result.errorMessage.shouldBeNull()
    }
}
