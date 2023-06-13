package com.example.zgadnijslowo.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val BackgroundLight = Color(0xFFFFE49D)
val BackgroundDark = Color(0xFF171717)
val SecondaryColor = Color(0XFFFFCD4B)
val lightWhiteColor = Color(0XFFF8F8F8)
val lightBeige = Color(0XFFFFF3D4)
val lightGrey = Color(0XFF333333)
val greenColor = Color(0XFF00BE13)

val lightRed = Color(0XFFFF4F4F)
val darkRed = Color(0XFFFF1F1F)

val Colors.backgroundColor
    @Composable
    get() = if(isSystemInDarkTheme()) BackgroundDark else BackgroundLight

val Colors.activeIndicatorColor
    @Composable
    get() = if(isSystemInDarkTheme()) SecondaryColor else Color.Black

val Colors.textColor
    @Composable
    get() = if(isSystemInDarkTheme()) lightWhiteColor else Color.Black

val Colors.imageBackgroundOnBoarding
    @Composable
    get() = if(isSystemInDarkTheme()) lightGrey else lightBeige

val Colors.buttonColor
    @Composable
    get() = if(isSystemInDarkTheme()) lightGrey else SecondaryColor


val Colors.loseWidget
    @Composable
    get() = if(isSystemInDarkTheme()) darkRed else lightRed