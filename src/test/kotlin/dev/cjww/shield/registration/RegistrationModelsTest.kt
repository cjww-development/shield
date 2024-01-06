/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RegistrationModelsTest {
    private val jsonMapper = ObjectMapper().registerKotlinModule()

    @Test
    fun `given a request all values should be correct`() {
        val result: Request =
            Request(
                emailAddress = "test@email.com",
                password = "S0meFakePa55word",
            )

        result.emailAddress.shouldBe("test@email.com")
        result.password.shouldBe("S0meFakePa55word")
    }

    @Test
    fun `given a JSON string it can be read into a Request data class`() {
        val testJson: String = """{"email_address": "test@email.com", "password": "S0meFakePa55word"}"""

        val result: Request = jsonMapper.readValue(testJson)

        val expected: Request =
            Request(
                emailAddress = "test@email.com",
                password = "S0meFakePa55word",
            )

        result.shouldBe(expected)
    }

    @Test
    fun `given a response all values should be correct`() {
        val result: Response =
            Response(
                message = "Test message",
                errorMessage = "Test error message",
            )

        result.message.shouldBe("Test message")
        result.errorMessage.shouldBe("Test error message")
    }

    @Test
    fun `given a response some values should be correct`() {
        val result: Response =
            Response(
                message = "Test message",
                errorMessage = null,
            )

        result.message.shouldBe("Test message")
        result.errorMessage.shouldBeNull()
    }

    @Test
    fun `given a response, it can be fully written to JSON`() {
        val testResponse: Response =
            Response(
                message = "Test message",
                errorMessage = "Test error message",
            )

        val result: String = jsonMapper.writeValueAsString(testResponse)

        val expected: String = """{"message":"Test message","error_message":"Test error message"}"""

        result.shouldBe(expected)
    }

    @Test
    fun `given a response, it can be partially written to JSON`() {
        val testResponse: Response =
            Response(
                message = "Test message",
                errorMessage = null,
            )

        val result: String = jsonMapper.writeValueAsString(testResponse)

        val expected: String = """{"message":"Test message"}"""

        result.shouldBe(expected)
    }
}
