package com.example.zgadnijslowo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity("words_table")
data class Word(
    @PrimaryKey
    val id: Int,
    val name: String,
    val letters: Int,
    val isRandomize: Boolean
)
