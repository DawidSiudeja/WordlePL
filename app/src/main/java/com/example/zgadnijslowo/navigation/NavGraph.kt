package com.example.zgadnijslowo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zgadnijslowo.presentation.screens.game.GameScreen
import com.example.zgadnijslowo.presentation.screens.home.HomeScreen
import com.example.zgadnijslowo.presentation.screens.onboarding.OnBoardingScreen
import com.example.zgadnijslowo.presentation.screens.wordlist.WordList

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.OnBoarding.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Game.route
        ) {
            GameScreen(navController = navController)
        }

        composable(
            route = Screen.OnBoarding.route
        ) {
            OnBoardingScreen(navController = navController)
        }

        composable(
            route = Screen.WordsList.route
        ) {
            WordList(navController = navController)
        }
    }
}