package com.example.zgadnijslowo.presentation.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zgadnijslowo.ui.theme.KEYBOARD_ELEMENT_HEIGHT
import com.example.zgadnijslowo.ui.theme.KEYBOARD_ELEMENT_RADIUS
import com.example.zgadnijslowo.ui.theme.KEYBOARD_ELEMENT_WIDTH
import com.example.zgadnijslowo.ui.theme.greenColor
import com.example.zgadnijslowo.ui.theme.imageBackgroundOnBoarding
import com.example.zgadnijslowo.ui.theme.loseWidget
import com.example.zgadnijslowo.ui.theme.textColor


@Composable
fun KeyboardWidget(
    onLetterClick: (String) -> Unit,
    onUndoClick: () -> Unit,
    onEnterClick: () -> Unit,
) {
    val polishAlphabet: List<String> =
        listOf(
            "a","ą","b","c","ć","d","e","ę","f","g",
            "h","i","j","k","l","ł","m","n","ń","o",
            "ó","p","r","s","ś","t","u","w","y","z",
            "ź","ż"
        )

    repeat(3) { rowIndex ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(10) { columnIndex ->
                val letterIndex = rowIndex * 10 + columnIndex
                KeyboardElement(
                    letter = polishAlphabet[letterIndex],
                    onLetterClick = onLetterClick,
                )
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SpecialKeyboardElement(
            onUndoClick = onUndoClick,
            onEnterClick = onEnterClick
        )
    }
}

@Composable
fun KeyboardElement(
    letter: String,
    onLetterClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .width(KEYBOARD_ELEMENT_WIDTH)
            .height(KEYBOARD_ELEMENT_HEIGHT)
            .clip(RoundedCornerShape(KEYBOARD_ELEMENT_RADIUS))
            .background(MaterialTheme.colors.imageBackgroundOnBoarding)
            .clickable {
                onLetterClick(letter)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter.uppercase(),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.textColor
        )
    }
}

@Composable
fun SpecialKeyboardElement(
    onUndoClick: () -> Unit,
    onEnterClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(.25f)
            .padding(end = 5.dp)
            .height(KEYBOARD_ELEMENT_HEIGHT)
            .clip(RoundedCornerShape(KEYBOARD_ELEMENT_RADIUS))
            .background(MaterialTheme.colors.loseWidget)
            .clickable {
                onUndoClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "UNDO",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(.33f)
            .padding(end = 5.dp)
            .height(KEYBOARD_ELEMENT_HEIGHT)
            .clip(RoundedCornerShape(KEYBOARD_ELEMENT_RADIUS))
            .background(MaterialTheme.colors.imageBackgroundOnBoarding)
            .clickable {
                // Obsługa kliknięcia przycisku specjalnego
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Ź",
            color = MaterialTheme.colors.textColor,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(.5f)
            .padding(end = 5.dp)
            .height(KEYBOARD_ELEMENT_HEIGHT)
            .clip(RoundedCornerShape(KEYBOARD_ELEMENT_RADIUS))
            .background(MaterialTheme.colors.imageBackgroundOnBoarding)
            .clickable {
                // Obsługa kliknięcia przycisku specjalnego
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Ż",
            color = MaterialTheme.colors.textColor,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(KEYBOARD_ELEMENT_HEIGHT)
            .clip(RoundedCornerShape(KEYBOARD_ELEMENT_RADIUS))
            .background(greenColor)
            .clickable {
                onEnterClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ENTER",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}