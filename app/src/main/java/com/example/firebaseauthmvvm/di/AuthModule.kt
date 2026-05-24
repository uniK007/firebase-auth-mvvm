package com.example.firebaseauthmvvm.di

import FirebaseAuthService
import com.example.firebaseauthmvvm.data.remote.auth.AuthService
import com.example.firebaseauthmvvm.data.repository.AuthRepositoryImpl
import com.example.firebaseauthmvvm.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthService(
        firebaseAuth: FirebaseAuth
    ): AuthService {
        return FirebaseAuthService(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authService: AuthService
    ): AuthRepository {
        return AuthRepositoryImpl(authService)
    }
}