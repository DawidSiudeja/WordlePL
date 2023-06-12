package com.example.zgadnijslowo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.zgadnijslowo.domain.model.Word

@Dao
interface WordsDao {

    @Insert
    suspend fun insertWords(word: List<Word>)

    @Query("SELECT * FROM words_table")
    suspend fun getWords(): List<Word>


}