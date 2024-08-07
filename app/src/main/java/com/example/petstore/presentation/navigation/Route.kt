package com.example.petstore.presentation.navigation

sealed class Route(val path: String) {

    data object StartScreen : Route(path = "start_screen")
    data object LogInScreen : Route(path = "log_in_screen")
    data object SignUpScreen : Route(path = "sign_up_screen")
    data object MainScreen : Route(path = "main_screen")
}