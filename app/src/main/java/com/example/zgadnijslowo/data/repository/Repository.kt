package com.example.zgadnijslowo.data.repository

import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {
    suspend fun getAllWords() {
        return remote.getAllWordsFromAPI()
    }

    suspend fun getRandomWordFromAPI(letters: String): Flow<Word> {
        return remote.getRandomWordFromAPI(letters)
    }
}