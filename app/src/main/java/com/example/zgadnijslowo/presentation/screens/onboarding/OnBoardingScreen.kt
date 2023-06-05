package com.example.zgadnijslowo.presentation.screens.onboarding

import android.graphics.fonts.FontStyle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zgadnijslowo.domain.model.OnBoardingPage
import com.example.zgadnijslowo.navigation.Screen
import com.example.zgadnijslowo.ui.theme.BODY_PADDING
import com.example.zgadnijslowo.ui.theme.activeIndicatorColor
import com.example.zgadnijslowo.ui.theme.backgroundColor
import com.example.zgadnijslowo.ui.theme.buttonColor
import com.example.zgadnijslowo.ui.theme.imageBackgroundOnBoarding
import com.example.zgadnijslowo.ui.theme.lightWhiteColor
import com.example.zgadnijslowo.ui.theme.textColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: OnBoardingScreenViewModel = hiltViewModel(),
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
        OnBoardingPage.Fourth
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.backgroundColor)
            .padding(BODY_PADDING)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 4,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            PagerScreen(pages[it])
        }
        FinisherButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = lightWhiteColor,
            indicatorHeight = 12.dp,
            indicatorWidth = 12.dp
        )



    }
}

@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .aspectRatio(1f)
                .background(
                    color = MaterialTheme.colors.imageBackgroundOnBoarding,
                    shape = CircleShape
                ),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "On Boarding Image",
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = onBoardingPage.description,
            color = MaterialTheme.colors.textColor,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinisherButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        AnimatedVisibility(
            modifier = modifier.fillMaxSize(),
            visible = pagerState.currentPage == 3
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonColor,
                    contentColor = lightWhiteColor
                ),

            ) {
                Text(
                    text = "Koniec",
                    fontSize = MaterialTheme.typography.button.fontSize,
                )
            }
        }
    }
}