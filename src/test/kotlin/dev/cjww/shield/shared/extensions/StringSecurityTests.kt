/*
 * Copyright 2023 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.shared.extensions

import dev.cjww.shield.shared.extensions.StringSecurity.hash
import org.junit.jupiter.api.Test

class StringSecurityTests {

    @Test
    fun `generateRandomSalt should produce a string with the correct length`() {
        val testSalt1: String = StringSecurity.generateRandomSalt(16)
        val testSalt2: String = StringSecurity.generateRandomSalt(32)

        assert(testSalt1.count() == 16)
        assert(testSalt2.count() == 32)
    }

    @Test
    fun `generateRandomSalt should produce a random string each time`() {
        val testSalt1: String = StringSecurity.generateRandomSalt(16)
        val testSalt2: String = StringSecurity.generateRandomSalt(16)

        assert(testSalt1 != testSalt2)
    }

    @Test
    fun `String hash should produce a string that's 64 chars in length`() {
        val testSalt: String = "testSaltString"
        val testStringToHash: String = "testStringToHash"

        val result: String = testStringToHash.hash(testSalt)

        assert(result.count() == 64)
    }

    @Test
    fun `String hash should produce a string that's not equal to the input`() {
        val testSalt: String = "testSaltString"
        val testStringToHash: String = "testStringToHash"

        val result: String = testStringToHash.hash(testSalt)

        assert(testStringToHash != result)
    }

    @Test
    fun `String hash should return the same has when using the same hash on the same input`() {
        val testSalt: String = "testSaltString"
        val testStringToHash: String = "testStringToHash"

        val result1: String = testStringToHash.hash(testSalt)
        val result2: String = testStringToHash.hash(testSalt)

        assert(result1 == result2)
    }

    @Test
    fun `String hash should not return the same hash when using different salts on the same input`() {
        val testSalt1: String = "testSaltString1"
        val testSalt2: String = "testSaltString2"
        val testStringToHash: String = "testStringToHash"

        val result1: String = testStringToHash.hash(testSalt1)
        val result2: String = testStringToHash.hash(testSalt2)

        assert(result1 != result2)
    }
}