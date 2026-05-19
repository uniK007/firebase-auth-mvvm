package com.example.firebaseauthmvvm.presentation.login

import com.example.firebaseauthmvvm.domain.model.User

data class LoginState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)