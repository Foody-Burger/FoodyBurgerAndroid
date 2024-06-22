package com.foodyburger.model

import com.foodyburger.common.OpResult
import com.foodyburger.model.signin.LoggedInUser

interface SignInDataSource {

    fun register(
        username: String,
        password: String,
        email: String
    ): OpResult<Any>

    fun login(
        username: String,
        password: String
    ): OpResult<LoggedInUser>

    fun logout(): OpResult<Any>
}