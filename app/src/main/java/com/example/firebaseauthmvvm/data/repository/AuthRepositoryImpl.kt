package com.example.firebaseauthmvvm.data.repository

import com.example.firebaseauthmvvm.data.remote.auth.AuthService
import com.example.firebaseauthmvvm.domain.model.User
import com.example.firebaseauthmvvm.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository{
    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        return try {
            Result.success(authService.login(email, password))
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): Result<User> {
        return try {
            Result.success(authService.register(email, password))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun logout() {
        authService.logout()
    }

    override fun getCurrentUser(): User? {
        return authService.getCurrentUser()
    }
}