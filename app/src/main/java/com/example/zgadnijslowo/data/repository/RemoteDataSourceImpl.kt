package com.example.zgadnijslowo.data.repository


import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.remote.WordsApi
import com.example.zgadnijslowo.domain.model.Word
import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
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

        wordsDao.deleteAllWords()

        wordsDao.insertWords(response)

    }

    override suspend fun getRandomWordFromAPI(letters: String): Flow<Word> {
        return wordsApi.getRandomWord(letters).words.asFlow()
    }

}