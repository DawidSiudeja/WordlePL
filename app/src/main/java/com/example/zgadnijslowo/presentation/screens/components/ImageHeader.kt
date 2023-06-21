package com.example.zgadnijslowo.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zgadnijslowo.R
import com.example.zgadnijslowo.navigation.Screen

@Composable
fun ImageHeader(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .clickable { navController.navigate(Screen.Home.route) },
            painter = (if(isSystemInDarkTheme()) {
                painterResource(id = R.drawable.logo_dark)
            } else {
                painterResource(id = R.drawable.logo)
            }),
            contentDescription = "Logo"
        )
    }
}