package com.example.firebaseauthmvvm.domain.usecase

import com.example.firebaseauthmvvm.domain.model.User
import com.example.firebaseauthmvvm.domain.repository.AuthRepository

class GetCurrentUserUseCase @Inject constructor(
    private val repository: AuthRepository
){
    suspend operator fun invoke(): User?{
        return repository.getCurrentUser()
    }
}