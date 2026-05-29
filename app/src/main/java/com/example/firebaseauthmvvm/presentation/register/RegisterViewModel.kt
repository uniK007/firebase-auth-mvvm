package com.example.firebaseauthmvvm.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseauthmvvm.common.Result
import com.example.firebaseauthmvvm.common.ValidationUtils
import com.example.firebaseauthmvvm.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val registerUseCase : RegisterUseCase
): ViewModel() {
    private val _state = MutableStateFlow(RegisterState())

    val state = _state.asStateFlow()

    fun onPasswordChanged(
        password: String
    ) {
        val validation = ValidationUtils.validatePassword(password)

        _state.update { it.copy(passwordValidation = validation) }
    }

    fun register(email: String, password: String, confirmPassword: String) {
        val emailErr = ValidationUtils.validateEmail(email)
        val passwordValidation = ValidationUtils.validatePassword(password)
        val confirmPasswordErr = if (password != confirmPassword)
            "Password don't match"
        else
            null

        if (emailErr != null || !passwordValidation.isValid() || confirmPasswordErr != null) {
            _state.update { it.copy(
                emailError = emailErr,
                passwordValidation = passwordValidation,
                confirmPasswordError = confirmPasswordErr
            ) }

            return
        }

        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true,
                error = null
            ) }

            when (val result = registerUseCase(email, password)) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            user =  result.data
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
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }
}