/*
 * Copyright 2023 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.shared.models

data class User(
    val id: Int,
    val emailAddress: String,
    val password: String,
    val createdAt: String,
)
