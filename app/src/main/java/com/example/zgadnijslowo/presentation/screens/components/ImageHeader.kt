package com.example.zgadnijslowo.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zgadnijslowo.R

@Composable
fun ImageHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = (if(isSystemInDarkTheme()) {
                painterResource(id = R.drawable.logo)
            } else {
                painterResource(id = R.drawable.logo_dark)
            }),
            contentDescription = "Logo"
        )
    }
}