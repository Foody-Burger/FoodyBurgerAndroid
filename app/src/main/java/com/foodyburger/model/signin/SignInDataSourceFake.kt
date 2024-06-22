package com.foodyburger.model.signin

import com.foodyburger.faking.errorBehavior
import com.foodyburger.faking.FakeImpl
import com.foodyburger.common.OpResult
import com.foodyburger.model.SignInDataSource
import kotlinx.coroutines.delay

// TODO: Perhaps move this somewhere to UI tests? IDK.
@FakeImpl
class SignInDataSourceFake : SignInDataSource {

    override suspend fun register(
        username: String,
        password: String,
        email: String
    ): OpResult<Any> {
        delay(2000L)

        if (this.errorBehavior()) {
            return OpResult.Error("registerError")
        }

        return OpResult.success()
    }

    override suspend fun login(username: String, password: String): OpResult<LoggedInUser> {
        delay(2000L)

        if (this.errorBehavior()) {
            return OpResult.Error("loginError")
        }

        val id = java.util.UUID.randomUUID().toString()
        val name = "Jane Doe"
        val fakeUser = LoggedInUser(id, name)
        return OpResult.Success(fakeUser)
    }

    override suspend fun logout(): OpResult<Any> {
        delay(2000L)

        if (this.errorBehavior()) {
            return OpResult.Error("logoutError")
        }

        return OpResult.success()
    }
}