package com.example.zgadnijslowo.domain.repository

import com.example.zgadnijslowo.domain.model.Word
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {
    suspend fun getAllWordsFromAPI()
    suspend fun getRandomWordFromAPI(letters: String): Flow<Word>
}