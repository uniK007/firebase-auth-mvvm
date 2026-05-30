package com.example.firebaseauthmvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauthmvvm.presentation.login.LoginScreen
import com.example.firebaseauthmvvm.presentation.login.LoginViewModel
import com.example.firebaseauthmvvm.presentation.register.RegisterScreen
import com.example.firebaseauthmvvm.presentation.register.RegisterViewModel


@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination  = Screen.Login.route
    ) {
        composable(
            route = Screen.Login.route
        ) {
            val viewModel: LoginViewModel = hiltViewModel()

            val state = viewModel.state.collectAsState()

            LoginScreen(
                state = state.value,
                onLoginClick = { email, password ->
                    viewModel.login(
                        email, password
                    )
                },
                onPasswordChanged = {
                    viewModel.onPasswordChanged(it)
                },
                onRegisterClick = {
                    navController.navigate(
                        Screen.Register.route
                    )
                }
            )
        }

        composable(
            route = Screen.Register.route
        ) {
            val viewModel: RegisterViewModel = hiltViewModel()

            val state = viewModel.state.collectAsState()

            RegisterScreen(
                state = state.value,
                onRegisterClick = {
                        email,
                        password,
                        confirmPassword ->

                    viewModel.register(
                        email,
                        password,
                        confirmPassword
                    )
                },
                onPasswordChanged = {
                    viewModel.onPasswordChanged(it)
                },
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}