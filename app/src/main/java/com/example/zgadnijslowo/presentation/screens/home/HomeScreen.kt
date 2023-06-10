package com.example.zgadnijslowo.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zgadnijslowo.R
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.navigation.Screen
import com.example.zgadnijslowo.presentation.screens.components.ImageHeader
import com.example.zgadnijslowo.presentation.screens.onboarding.OnBoardingScreenViewModel
import com.example.zgadnijslowo.ui.theme.BODY_PADDING
import com.example.zgadnijslowo.ui.theme.backgroundColor
import com.example.zgadnijslowo.ui.theme.buttonColor
import com.example.zgadnijslowo.ui.theme.lightBeige
import com.example.zgadnijslowo.ui.theme.textColor

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {

    val userInfo = viewModel.getAllUserInfoData().collectAsState(initial = UserInfo(id = 0)).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundColor),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            ImageHeader()
            UserStats(userInfo = userInfo)
        }
        Column {
            StartGameAndWordListBtn(
                startGame = { navController.navigate(Screen.Game.route) },
                wordList = {}
            )
        }
    }
}

@Composable
fun UserStats(
    userInfo: UserInfo
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = BODY_PADDING)
    ) {
        Column() {
            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = "Statystyki",
                color = MaterialTheme.colors.textColor,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Rozegrane gry",
                    color = MaterialTheme.colors.textColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                )
                Text(
                    text = userInfo.gamesPlayed.toString(),
                    color = MaterialTheme.colors.textColor,
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            }
            if (userInfo.gamesPlayed != 0) {
                winLoseWidget(userInfo = userInfo)
            }
        }
    }
}


@Composable
fun StartGameAndWordListBtn(
    startGame: () -> Unit,
    wordList: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = BODY_PADDING)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = startGame,
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonColor
                )
            ) {
                Text(
                    text = "Rozpocznij grę",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            TextButton(
                onClick = wordList,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    disabledBackgroundColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.border(width = 0.dp, color = Color.Transparent)
            ) {
                Text(
                    text = "Lista słów",
                    color = MaterialTheme.colors.textColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                )
            }
        }

    }
}