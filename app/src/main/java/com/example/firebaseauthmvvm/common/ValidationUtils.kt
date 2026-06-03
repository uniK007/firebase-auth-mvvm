package com.example.firebaseauthmvvm.common

import android.util.Patterns
import com.example.firebaseauthmvvm.domain.model.PasswordValidationResult

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

    // minimum 8 digit password required
    fun validatePassword(
        password: String
    ) : PasswordValidationResult {
        return PasswordValidationResult(
            hasMinLength = password.length >= 8,
            hasNumber = password.any { it.isDigit() },
            hasLowerCase = password.any { it.isLowerCase() },
            hasUpperCase = password.any { it.isUpperCase() },
            hasSpecialCharacter = password.any { !it.isLetterOrDigit() }
        )
    }
}