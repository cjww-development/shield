/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration.models

import org.junit.jupiter.api.Test

class RequestTests {
    @Test
    fun `given a request all values should be correct`() {
        val result: Request =
            Request(
                emailAddress = "test@email.com",
                password = "S0meFakePa55word",
            )

        assert(result.emailAddress == "test@email.com")
        assert(result.password == "S0meFakePa55word")
    }
}
