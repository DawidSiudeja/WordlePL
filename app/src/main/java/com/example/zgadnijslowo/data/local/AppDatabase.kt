package com.example.zgadnijslowo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zgadnijslowo.data.local.dao.UserInfoDao
import com.example.zgadnijslowo.data.local.dao.WordsDao
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.domain.model.Word

@Database(entities = [UserInfo::class, Word::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao
    abstract fun wordsDao(): WordsDao

}