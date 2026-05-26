package com.example.firebaseauthmvvm.presentation.login

import com.example.firebaseauthmvvm.domain.model.PasswordValidationResult
import com.example.firebaseauthmvvm.domain.model.User

/// Simple Login State
//data class LoginState(
//    val isLoading: Boolean = false,
//    val user: User? = null,
//    val error: String? = null,
//    val emailValidationError: String? = null,
//    val passwordValidationError: String? = null
//)

data class LoginState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null,
    val emailValidationError: String? = null,
    val passwordValidationError: PasswordValidationResult = PasswordValidationResult()
)