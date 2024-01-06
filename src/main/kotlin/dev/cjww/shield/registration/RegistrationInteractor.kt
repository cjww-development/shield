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
import org.springframework.stereotype.Service

interface RegistrationBusinessLogic {
    fun createUser(
        emailAddress: String,
        password: String,
    ): User?
}

@Service
class RegistrationInteractor : RegistrationBusinessLogic {
    override fun createUser(
        emailAddress: String,
        password: String,
    ): User? {
        TODO("Not yet implemented")
    }
}
