package com.example.zgadnijslowo.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Game: Screen("game_screen")
    object OnBoarding: Screen("on_boarding_screen")
    object WordsList: Screen("word_list_screen")
}