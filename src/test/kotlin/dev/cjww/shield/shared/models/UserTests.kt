/*
 * Copyright 2023 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.shared.models

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UserTests {
    private val mapper = ObjectMapper().registerKotlinModule()

    @Test
    fun `A User data class can be written to JSON`() {
        val testUser: User =
            User(
                id = 1,
                emailAddress = "test@email.com",
                password = "testPassword",
                createdAt = "testDate",
            )

        val result: String = mapper.writeValueAsString(testUser)

        val expected: String = """{"id":1,"emailAddress":"test@email.com","password":"testPassword","createdAt":"testDate"}"""

        result.shouldBe(expected)
    }

    @Test
    fun `A JSON string representing a User can be read into a User data class`() {
        val testJson: String = """{"id":1,"emailAddress":"test@email.com","password":"testPassword","createdAt":"testDate"}"""

        val result: User = mapper.readValue(testJson)

        result.id.shouldBe(1)
        result.emailAddress.shouldBe("test@email.com")
        result.password.shouldBe("testPassword")
        result.createdAt.shouldBe("testDate")
    }
}
