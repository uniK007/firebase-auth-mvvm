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

            password.length < 8 -> "Password must be at least 8 characters"

            !password.any { it.isDigit() } -> "Password must contain a number"

            !password.any { it.isLowerCase() } -> "Password must contain a lowercase"

            !password.any { it.isUpperCase() } -> "Password must contain an uppercase letter"

            !password.any { !it.isLetterOrDigit() } -> "Password must contain a special character"

            else -> null
        }
    }
}