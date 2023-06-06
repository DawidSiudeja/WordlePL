package com.example.zgadnijslowo.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.zgadnijslowo.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Text(
        modifier = Modifier
            .clickable {
                navController.navigate(Screen.Game.route)
            },
        text = "Home Screen"
    )
}