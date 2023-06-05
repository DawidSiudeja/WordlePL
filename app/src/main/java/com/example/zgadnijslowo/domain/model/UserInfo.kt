package com.example.zgadnijslowo.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info_table")
data class UserInfo(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val onBoardingIsFinished: Boolean = false,

    @ColumnInfo
    val gamesPlayed: Int = 0,

    @ColumnInfo
    val gamesWin: Int = 0,

)
