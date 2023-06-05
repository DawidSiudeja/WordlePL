package com.example.zgadnijslowo.data.repository

import com.example.zgadnijslowo.data.remote.WordsApi
import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val wordsApi: WordsApi
): Repository {
    override suspend fun getAllWords(): Flow<Word> {
        TODO("Not yet implemented")
    }
}