package com.example.zgadnijslowo.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.ui.theme.greenColor
import com.example.zgadnijslowo.ui.theme.loseWidget

@Composable
fun winLoseWidget(
    userInfo: UserInfo
) {
    val userGamesPlayed = userInfo.gamesPlayed
    val userGamesWin  = userInfo.gamesWin

    val userGamesLose = userGamesPlayed - userGamesWin

    var userGamesWinPercent: Double = userGamesWin.toDouble() / userGamesPlayed.toDouble() * 100
    userGamesWinPercent = String.format("%.2f", userGamesWinPercent).toDouble()

    val userGamesLosePercent = 100 - userGamesWinPercent


    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$userGamesWinPercent%",
                    color = greenColor,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$userGamesLosePercent%",
                    color = MaterialTheme.colors.loseWidget,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
            Row() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth((userGamesWinPercent/100).toFloat())
                        .height(20.dp)
                        .background(greenColor)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(MaterialTheme.colors.loseWidget)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$userGamesWin wygranych",
                    color = greenColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$userGamesLose przegranych",
                    color = MaterialTheme.colors.loseWidget,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}


@Preview
@Composable
fun winLoseWidgetPreview() {
    winLoseWidget(userInfo = UserInfo(id = 0, onBoardingIsFinished = true, gamesPlayed = 1330, gamesWin = 75))
}