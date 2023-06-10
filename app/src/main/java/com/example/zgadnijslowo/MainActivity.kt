package com.example.zgadnijslowo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.zgadnijslowo.navigation.SetupNavigation
import com.example.zgadnijslowo.ui.theme.ZgadnijSlowoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZgadnijSlowoTheme {
                SetupNavigation()
            }
        }
    }
}
