package com.example.zgadnijslowo.presentation.screens.game

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.repository.Repository
import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameScreenViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    useCases: UseCases
):ViewModel() {



    private lateinit var wordToGuess: String

    init {


        viewModelScope.launch {
            wordToGuess =
                useCases.getRandomWordFromApi(letters = "5").first().name

            Log.d("RANDOM", "The random word is: $wordToGuess")

            appDatabase.userInfoDao().increaseGamesPlayed()
        }
    }


    fun checkingEntryWord(
        wordToCheck: String,
        tries: Int
    ): List<String> {


        Log.d("RANDOM", "The random word is: $wordToGuess")

        val result = mutableListOf<String>()
        var correctChar = 0

        if (wordToCheck == wordToGuess) {
            repeat(wordToGuess.length) {
                result.add("great")
                correctChar++
            }
        } else {
            for (i in wordToCheck.indices) {
                val guessChar = wordToCheck[i]

                if (i < wordToGuess.length && guessChar == wordToGuess[i]) {
                    result.add("great")
                    correctChar++
                } else {
                    if (wordToGuess.contains(guessChar)) {
                        result.add("good")
                    }  else {
                        result.add("bad")
                    }
                }


            }
        }
        Log.d("ENTRY", "checkingEntryWord: $result, $wordToCheck")

        Log.d("GAME", "Number of tries: $tries, and correct chars: $correctChar")

        if(tries == 6 && correctChar != 5) {
            Log.d("GAME", "Loser")
            viewModelScope.launch {
                addGameToLocalDb(win = false)
            }
            result.add("lose")
        }

        if(correctChar==5) {
            Log.d("GAME", "Easy win")
            viewModelScope.launch {
                addGameToLocalDb(win = true)
            }
            result.add("win")
        }

        return result
    }

    private suspend fun addGameToLocalDb(win: Boolean) {
        if(win) {
            Log.d("GAME", "Easy win2")
            appDatabase.userInfoDao().increaseWinsPlayed()
        } else {
            Log.d("GAME", "Loser2")
            appDatabase.userInfoDao().increaseGamesPlayed()
        }
    }

}