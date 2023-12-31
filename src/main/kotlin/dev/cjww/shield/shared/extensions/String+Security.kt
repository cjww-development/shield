/*
 * Copyright 2023 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.shared.extensions

import java.security.spec.KeySpec
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

object StringSecurity {

    private const val ITERATIONS = 120_000
    private const val KEY_LENGTH = 256

    fun generateRandomSalt(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + (0..9)
        return (1..length)
            .map { allowedChars.random()}
            .joinToString("")
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun String.hash(salt: String): String {
        val byteSalt: ByteArray = salt.toByteArray()

        val secretKeyFactory: SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
        val keySpec: KeySpec = PBEKeySpec(this.toCharArray(), byteSalt, ITERATIONS, KEY_LENGTH)
        val key: SecretKey = secretKeyFactory.generateSecret(keySpec)
        val hash: ByteArray = key.encoded

        return hash.toHexString()
    }
}
