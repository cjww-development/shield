/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

interface RegistrationDisplayLogic {
    fun createUser(
        @RequestBody request: Request,
    ): Response
}

@RestController
@RequestMapping("/register")
class RegistrationController(
    @Autowired val registrationInteractor: RegistrationBusinessLogic,
) : RegistrationDisplayLogic {
    @PostMapping("/user")
    override fun createUser(
        @RequestBody request: Request,
    ): Response {
        val creationResponse =
            registrationInteractor.createUser(
                emailAddress = request.emailAddress,
                password = request.password,
            )

        if (creationResponse != null) {
            return Response(
                message = "Created new user",
                errorMessage = null,
            )
        }

        return Response(
            message = "Error",
            errorMessage = "Something went wrong",
        )
    }
}
