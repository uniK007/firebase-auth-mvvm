package com.example.firebaseauthmvvm.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseauthmvvm.common.Result
import com.example.firebaseauthmvvm.common.ValidationUtils
import com.example.firebaseauthmvvm.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())

    val state = _state.asStateFlow()

     fun login(email: String, password: String) {
         val emailErr = ValidationUtils.validateEmail(email)
         val passwordErr = ValidationUtils.validatePassword(password)

         if (emailErr !=null || !passwordErr.isValid()) {
             _state.update {
                 it.copy(
                     emailValidationError = emailErr,
                     passwordValidationError = passwordErr
                 )
             }
             return
         }

        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }

            when (val result = loginUseCase(email, password)) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            user = result.data
                        )
                    }
                }

                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.error
                        )
                    }
                }

                is Result.Loading -> {
                    _state.update {
                        it.copy(isLoading = true)
                    }
            }
            }
        }
    }

    fun onPasswordChanged(password: String) {
        val validation = ValidationUtils.validatePassword(password)

        _state.update { it.copy(passwordValidationError = validation) }
    }
}