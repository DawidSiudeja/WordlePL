package com.example.zgadnijslowo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zgadnijslowo.data.local.dao.UserInfoDao
import com.example.zgadnijslowo.domain.model.UserInfo

@Database(entities = [UserInfo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao

}