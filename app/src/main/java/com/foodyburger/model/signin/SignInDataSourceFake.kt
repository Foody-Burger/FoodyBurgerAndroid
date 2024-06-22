package com.foodyburger.model.signin

import com.foodyburger.faking.errorBehavior
import com.foodyburger.faking.FakeImpl
import com.foodyburger.common.OpResult
import com.foodyburger.model.SignInDataSource

// TODO: Perhaps move this somewhere to UI tests? IDK.
@FakeImpl
class SignInDataSourceFake : SignInDataSource {

    override fun register(
        username: String,
        password: String,
        email: String
    ): OpResult<Any> {
        if (this.errorBehavior()) {
            return OpResult.Error("registerError")
        }

        return OpResult.success()
    }

    override fun login(username: String, password: String): OpResult<LoggedInUser> {
        if (this.errorBehavior()) {
            return OpResult.Error("loginError")
        }

        val id = java.util.UUID.randomUUID().toString()
        val name = "Jane Doe"
        val fakeUser = LoggedInUser(id, name)
        return OpResult.Success(fakeUser)
    }

    override fun logout(): OpResult<Any> {
        if (this.errorBehavior()) {
            return OpResult.Error("logoutError")
        }

        return OpResult.success()
    }
}