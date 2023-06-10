package com.example.zgadnijslowo.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
): ViewModel() {

    private val userInfoDao = appDatabase.userInfoDao()

    fun getAllUserInfoData(): Flow<UserInfo> {
        return userInfoDao.getAllUserInfo()
    }

}