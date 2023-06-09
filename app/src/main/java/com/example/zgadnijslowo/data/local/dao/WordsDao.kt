package com.example.zgadnijslowo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zgadnijslowo.domain.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(word: List<Word>)

    @Query("SELECT * FROM words_table")
    fun getWords(): Flow<List<Word>>

    @Query("DELETE FROM words_table")
    suspend fun deleteAllWords()

}