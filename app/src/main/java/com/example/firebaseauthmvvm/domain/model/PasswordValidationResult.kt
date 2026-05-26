package com.example.firebaseauthmvvm.domain.model

data class PasswordValidationResult(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCase: Boolean = false,
    val hasUpperCase: Boolean = false,
    val hasSpecialCharacter: Boolean = false
) {
    fun isValid(): Boolean {
        return hasMinLength && hasNumber && hasLowerCase && hasUpperCase && hasSpecialCharacter
    }
}
