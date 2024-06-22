package com.foodyburger.model

import com.foodyburger.common.OpResult
import com.foodyburger.model.signin.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(private val dataSource: SignInDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    suspend fun logout() {
        user = null
        dataSource.logout()
    }

    suspend fun login(username: String, password: String): OpResult<LoggedInUser> {
        // handle login
        val result: OpResult<LoggedInUser> = dataSource.login(username, password)

        if (result is OpResult.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    companion object {
        private val loginRepository: LoginRepository

        init {
            val provider = SignInDataSourceProvider.requireDefault()
            loginRepository = LoginRepository(provider.requireSignInDataSource())
        }

        fun default(): LoginRepository {
            return loginRepository;
        }
    }
}