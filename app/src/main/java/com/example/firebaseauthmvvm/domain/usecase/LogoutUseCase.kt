package com.example.firebaseauthmvvm.domain.usecase

import com.example.firebaseauthmvvm.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repository: AuthRepository
){
    suspend operator fun  invoke() {
        return repository.logout()
    }
}