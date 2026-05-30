package com.example.firebaseauthmvvm.presentation.navigation

sealed class Screen (val route: String) {
    data object Splash: Screen("Splash")
    data object Login: Screen("login")
    data object Register: Screen("register")
    data object Home: Screen("home")
}
