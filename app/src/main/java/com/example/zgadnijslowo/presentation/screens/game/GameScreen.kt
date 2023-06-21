package com.example.zgadnijslowo.presentation.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zgadnijslowo.navigation.Screen
import com.example.zgadnijslowo.presentation.screens.components.ImageHeader
import com.example.zgadnijslowo.ui.theme.BODY_PADDING
import com.example.zgadnijslowo.ui.theme.backgroundColor
import com.example.zgadnijslowo.ui.theme.greenColor
import com.example.zgadnijslowo.ui.theme.imageBackgroundOnBoarding
import com.example.zgadnijslowo.ui.theme.lightGreyGameColor
import com.example.zgadnijslowo.ui.theme.yellowGameColor

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameScreenViewModel = hiltViewModel(),
) {
    val letters = remember { mutableStateListOf<String>() }
    var entryWords = remember { mutableStateListOf<String>() }
    var boxColor = remember { mutableStateListOf<Color>() }
    var showDialog = remember { mutableStateOf(false) }
    var resultOfGame = remember { mutableStateOf("") }
    var message = remember { mutableStateOf("Czy chcesz zagrać kolejną grę?") }
    val maxNumberOfTries = 6


    var wordCount = 0
    var word: String

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundColor)
            .padding(horizontal = BODY_PADDING)
            .padding(bottom = BODY_PADDING),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ImageHeader(navController)

        MainGamePanelRow(
            letters = letters,
            boxColors = boxColor,
            numberOfTries = maxNumberOfTries
        )

        KeyboardWidget(
            onLetterClick = { letter ->
                if(wordCount < 5) {
                    letters.add(letter)
                    wordCount++
                }
            },
            onUndoClick = {

                if (letters.size > 0 && entryWords.size == 0) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                if (letters.size > 5 && entryWords.size == 1) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                if (letters.size > 10 && entryWords.size == 2) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                if (letters.size > 15 && entryWords.size == 3) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                if (letters.size > 20 && entryWords.size == 4) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                if (letters.size > 25 && entryWords.size == 5) {
                    letters.removeAt(letters.size - 1)
                    wordCount--
                }
                //
            },
            onEnterClick = {
                val wordIsInListOfWords = true

                if (wordIsInListOfWords && wordCount == 5) {
                    wordCount = 0
                    word = ""

                    if(entryWords.size == 0) {
                        for (x in letters) {
                            word += x
                        }
                    }
                    if(entryWords.size == 1) {
                        for (i in 5..9) {
                            word += letters[i]
                        }
                    }
                    if(entryWords.size == 2) {
                        for (i in 10..14) {
                            word += letters[i]
                        }
                    }
                    if(entryWords.size == 3) {
                        for (i in 15..19) {
                            word += letters[i]
                        }
                    }
                    if(entryWords.size == 4) {
                        for (i in 20..24) {
                            word += letters[i]
                        }
                    }
                    if(entryWords.size == 5) {
                        for (i in 25..29) {
                            word += letters[i]
                        }
                    }
                    //
                    entryWords.add(word)
                    var tries = entryWords.size
                    var result =
                        viewModel.checkingEntryWord(
                            wordToCheck = word,
                            tries = tries,
                            maxNumberOfTries = maxNumberOfTries,
                            wordLength = 5
                        )
                    changingBoxColors(result = result, boxColor = boxColor)


                    if (result[result.size - 1].contains("lose")) {
                        resultOfGame.value = "Przegrana!"
                        val wordToGuess =
                            result[result.size -1].removePrefix("lose").capitalize()
                        message.value =
                            "Nieodgadnięte słowo to: " + wordToGuess + "\n" + message.value
                        showDialog.value = true
                    }
                    if (result[result.size - 1] == "win") {
                        resultOfGame.value = "Wygrana!"
                        showDialog.value = true
                    }
                }
            }
        )

    }



    EndGameDialog(
        showDialog = showDialog.value,
        onDismiss = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
        },
        onConfirm = {
            navController.popBackStack()
            navController.navigate(Screen.Game.route)
        },
        title = resultOfGame.value,
        message = message.value,
    )
}

@Composable
fun MainGamePanelRow(
    letters: List<String>,
    boxColors: List<Color>,
    numberOfTries: Int
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        repeat(numberOfTries) { rowIndex ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(5) { columnIndex ->
                    val index = rowIndex * 5 + columnIndex
                    val letter = letters.getOrNull(index) ?: ""
                    val boxColor = boxColors.getOrNull(index) ?: MaterialTheme.colors.imageBackgroundOnBoarding
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(boxColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = letter.uppercase(),
                            color = Color.White,
                            fontSize = MaterialTheme.typography.h4.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}


fun changingBoxColors(
    result: List<String>,
    boxColor: MutableList<Color>
) {
    // Example result = [bad, bad, good, great, bad]

    for(x in result) {
        if(x == "bad") {
            boxColor.add(lightGreyGameColor)
        }
        if(x == "good") {
            boxColor.add(yellowGameColor)
        }
        if(x == "great") {
            boxColor.add(greenColor)
        }
    }
}



