package com.example.zgadnijslowo.presentation.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameScreenViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    private val repository: Repository
):ViewModel() {

    var wordToGuess = "towar"

    fun checkingEntryWord(
        wordToCheck: String
    ): List<String> {

        val result = mutableListOf<String>()

        if (wordToCheck == wordToGuess) {
            repeat(wordToGuess.length) {
                result.add("great")
            }
        } else {
            for (i in wordToCheck.indices) {
                val guessChar = wordToCheck[i]

                if (i < wordToGuess.length && guessChar == wordToGuess[i]) {
                    result.add("great")
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
        return result
    }
}