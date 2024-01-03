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

class ResponseTests {
    @Test
    fun `given a response all values should be correct`() {
        val result: Response =
            Response(
                message = "Test message",
                errorMessage = "Test error message",
            )

        assert(result.message == "Test message")
        assert(result.errorMessage == "Test error message")
    }

    @Test
    fun `given a response some values should be correct`() {
        val result: Response =
            Response(
                message = "Test message",
                errorMessage = null,
            )

        assert(result.message == "Test message")
        assert(result.errorMessage == null)
    }
}
