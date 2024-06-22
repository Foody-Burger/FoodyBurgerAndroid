package com.foodyburger.model

import com.foodyburger.faking.FakeAble
import com.foodyburger.faking.fakingEnabled
import com.foodyburger.model.signin.SignInDataSourceFake

class SignInDataSourceProvider {
    @FakeAble
    fun requireSignInDataSource(): SignInDataSource {
        if (fakingEnabled()) {
            return SignInDataSourceFake()
        }

        // TODO: Put here real SignInDataSource.
        return SignInDataSourceFake()
    }

    companion object {
        fun requireDefault(): SignInDataSourceProvider {
            return SignInDataSourceProvider()
        }
    }
}