package com.example.zgadnijslowo.presentation.screens.wordlist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.presentation.screens.components.ImageHeader
import com.example.zgadnijslowo.ui.theme.BODY_PADDING
import com.example.zgadnijslowo.ui.theme.backgroundColor
import com.example.zgadnijslowo.ui.theme.buttonColor
import com.example.zgadnijslowo.ui.theme.textColor
import kotlinx.coroutines.flow.collect

@Composable
fun WordList(
    navController: NavController,
    viewModel: WordListViewModel = hiltViewModel()
) {

    val wordsList = viewModel.getAllWordsFromLocalDatabase()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundColor)
            .padding(horizontal = BODY_PADDING)
    ) {
        ImageHeader()
        Text(
            modifier = Modifier
                .padding(bottom = 16.dp),
            text = "Lista słów",
            color = MaterialTheme.colors.textColor,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h5.fontSize
        )

        LazyColumn {
            items(
                count = wordsList.size
            ) {
                SingleWord(word = wordsList[it])
            }
        }
    }

}


@Composable
fun SingleWord(
    word: Word,

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp)
    ) {
        Text(text = word.id.toString() + ": "  + word.name.capitalize())

    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colors.buttonColor)
    )
}