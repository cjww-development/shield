/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration

import dev.cjww.shield.shared.models.User

class RegistrationInteractorSpy : RegistrationBusinessLogic {
    override fun createUser(
        emailAddress: String,
        password: String,
    ): User? {
        return User(
            id = 1,
            emailAddress = "test",
            password = "test",
            createdAt = "test",
        )
    }
}

data class Test(val x: String)
