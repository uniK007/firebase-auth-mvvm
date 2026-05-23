package com.example.firebaseauthmvvm.data.repository

import com.example.firebaseauthmvvm.data.remote.auth.AuthService
import com.example.firebaseauthmvvm.domain.model.User
import com.example.firebaseauthmvvm.domain.repository.AuthRepository
import javax.inject.Inject
import com.example.firebaseauthmvvm.common.Result

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository{
    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        return try {
            Result.Success(authService.login(email, password))
        } catch (e: Exception){
            Result.Error(e.message ?: "Login error")
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): Result<User> {
        return try {
            Result.Success(authService.register(email, password))
        } catch (e: Exception) {
            Result.Error(e.message ?: "User can't be registered")
        }
    }

    override fun logout() {
        authService.logout()
    }

    override fun getCurrentUser(): User? {
        return authService.getCurrentUser()
    }
}