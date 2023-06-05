package com.example.zgadnijslowo.domain.repository

import com.example.zgadnijslowo.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllWords(): Flow<Word>
}