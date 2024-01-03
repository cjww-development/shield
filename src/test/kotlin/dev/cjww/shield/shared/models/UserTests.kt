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
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test

class UserTests {
    private val mapper = ObjectMapper().registerModule(KotlinModule())

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

        assert(result == expected)
    }

    @Test
    fun `A JSON string representing a User can be read into a User data class`() {
        val testJson: String = """{"id":1,"emailAddress":"test@email.com","password":"testPassword","createdAt":"testDate"}"""

        val result: User = mapper.readValue(testJson)

        assert(result.id == 1)
        assert(result.emailAddress == "test@email.com")
        assert(result.password == "testPassword")
        assert(result.createdAt == "testDate")
    }
}
