/*
 * Copyright 2024 CJWW Development
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
 */

package dev.cjww.shield.registration

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

data class Request(
    @JsonProperty("email_address")
    val emailAddress: String,
    @JsonProperty("password")
    val password: String,
)

data class Response(
    @JsonProperty("message")
    val message: String,
    @JsonProperty("error_message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val errorMessage: String?,
)
