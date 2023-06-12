package com.example.zgadnijslowo.data.repository

import android.util.Log
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.remote.WordsApi
import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val wordsApi: WordsApi,
    private val appDatabase: AppDatabase
): RemoteDataSource {

    private val wordsDao = appDatabase.wordsDao()

    override suspend fun getAllWordsFromAPI() {

        val response = withContext(Dispatchers.IO) {
            wordsApi.getAllWords().words
        }

        Log.d("getAllWords", "Received words: $response")

        wordsDao.insertWords(response)

        Log.d("getAllWords", "Inserted words into database")

    }
}