package com.example.zgadnijslowo.presentation.screens.wordlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class WordListViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    ): ViewModel() {

    private val _words = MutableStateFlow<List<Word>>(emptyList())
    private val words: MutableStateFlow<List<Word>> = _words

    fun getAllWordsFromLocalDatabase(): List<Word> {
        viewModelScope.launch {
            appDatabase.wordsDao().getWords().collect { words ->
                _words.value = words
            }
        }
        return words.value
    }


}