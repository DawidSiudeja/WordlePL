package com.example.zgadnijslowo.data.repository

import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {
    suspend fun getAllWords()
    {
        return remote.getAllWordsFromAPI()
    }
}