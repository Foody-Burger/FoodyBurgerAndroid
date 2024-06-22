package com.foodyburger.ui.signin.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.foodyburger.model.LoginRepository
import com.foodyburger.model.signin.SignInDataSourceFake

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository.default()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}