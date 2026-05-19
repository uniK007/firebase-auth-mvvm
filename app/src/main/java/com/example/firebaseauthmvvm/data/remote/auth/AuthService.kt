package com.example.firebaseauthmvvm.data.remote.auth

import com.example.firebaseauthmvvm.domain.model.User

interface AuthService {
    suspend fun login(email:String, password:String): User
    suspend fun register(email: String,password: String): User

    fun logout()
    fun getCurrentUser(): User?
}