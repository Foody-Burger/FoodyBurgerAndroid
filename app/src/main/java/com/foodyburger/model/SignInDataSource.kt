package com.foodyburger.model

import com.foodyburger.common.OpResult
import com.foodyburger.model.signin.LoggedInUser

interface SignInDataSource {

    suspend fun register(
        username: String,
        password: String,
        email: String
    ): OpResult<Any>

    suspend fun login(
        username: String,
        password: String
    ): OpResult<LoggedInUser>

    suspend fun logout(): OpResult<Any>
}