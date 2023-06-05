package com.example.zgadnijslowo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zgadnijslowo.presentation.screens.game.GameScreen
import com.example.zgadnijslowo.presentation.screens.home.HomeScreen
import com.example.zgadnijslowo.presentation.screens.onboarding.OnBoardingScreen

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
            HomeScreen()
        }

        composable(
            route = Screen.Game.route
        ) {
            GameScreen()
        }

        composable(
            route = Screen.OnBoarding.route
        ) {
            OnBoardingScreen(navController = navController)
        }
    }
}