package com.example.firebaseauthmvvm.common

import android.util.Patterns

object ValidationUtils {
    fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "Email is required"

            !Patterns.EMAIL_ADDRESS
                .matcher(email)
                .matches() -> "Invalid email format"

            else -> null
        }
    }

    fun validatePassword(
        password: String
    ): String? {
        return when {
            password.isBlank() -> "Password is required"

            password.length < 6 -> "Password must be at least 6 characters"

            !password.any { it.isDigit() } -> "Password must contain a number"

            else -> null
        }
    }
}