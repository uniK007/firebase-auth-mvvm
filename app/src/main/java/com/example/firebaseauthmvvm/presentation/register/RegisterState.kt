package com.example.firebaseauthmvvm.presentation.register

import com.example.firebaseauthmvvm.domain.model.PasswordValidationResult
import com.example.firebaseauthmvvm.domain.model.User

data class RegisterState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null,
    val emailError: String? = null,
    val confirmPasswordError: String? = null,
    val passwordValidation: PasswordValidationResult = PasswordValidationResult()
)
