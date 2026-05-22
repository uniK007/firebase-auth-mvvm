package com.example.firebaseauthmvvm.presentation.login

import androidx.lifecycle.ViewModel
import com.example.firebaseauthmvvm.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val state = MutableStateFlow(LoginState())
}