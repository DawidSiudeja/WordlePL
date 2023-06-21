package com.example.zgadnijslowo.presentation.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
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
            viewModelScope.launch {
                addGameToLocalDb(win = false)
            }
            result.add("lose$wordToGuess")
        }

        if(correctChar==5) {
            viewModelScope.launch {
                addGameToLocalDb(win = true)
            }
            result.add("win")
        }

        return result
    }

    private suspend fun addGameToLocalDb(win: Boolean) {
        if(win) {
            appDatabase.userInfoDao().increaseWinsPlayed()
        }
    }

}