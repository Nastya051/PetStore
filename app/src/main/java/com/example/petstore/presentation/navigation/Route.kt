package com.example.petstore.presentation.navigation

sealed class Route(val path: String) {

    data object StartScreen : Route(path = "start_screen")
}