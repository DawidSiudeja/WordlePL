package com.example.zgadnijslowo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zgadnijslowo.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM user_info_table")
    fun getAllUserInfo(): Flow<UserInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserInfo(userInfo: UserInfo)

    @Query("UPDATE user_info_table SET gamesPlayed = gamesPlayed + 1")
    suspend fun increaseGamesPlayed()

    @Query("UPDATE user_info_table SET gamesWin = gamesWin + 1")
    suspend fun increaseWinsPlayed()

    @Query("UPDATE user_info_table SET onBoardingIsFinished = 1")
    suspend fun setOnBoardingFinished()

}