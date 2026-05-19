package com.example.firebaseauthmvvm.domain.repository

import com.example.firebaseauthmvvm.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String) : Result<User>

    suspend fun register(email: String, password: String) : Result<User>

    fun logout()

    fun getCurrentUser(): User?
}