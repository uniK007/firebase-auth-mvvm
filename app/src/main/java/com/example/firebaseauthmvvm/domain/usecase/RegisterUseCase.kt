package com.example.firebaseauthmvvm.domain.usecase

import com.example.firebaseauthmvvm.domain.model.User
import com.example.firebaseauthmvvm.domain.repository.AuthRepository
import javax.inject.Inject
import com.example.firebaseauthmvvm.common.Result

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        return repository.register(email, password)
    }
}