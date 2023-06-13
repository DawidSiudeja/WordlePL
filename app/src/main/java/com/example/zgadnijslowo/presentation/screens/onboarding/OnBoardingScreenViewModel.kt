package com.example.zgadnijslowo.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingScreenViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
): ViewModel() {

    private val userInfoDao = appDatabase.userInfoDao()

    init {

        val userInfo = UserInfo(id = 0)
        viewModelScope.launch {
            userInfoDao.addUserInfo(userInfo = userInfo)
        }

    }
    fun getAllUserInfoData(): Flow<UserInfo> {
        return userInfoDao.getAllUserInfo()
    }

    fun setOnBoardingToCompleted() {
        viewModelScope.launch {
            userInfoDao.setOnBoardingToCompleted()
        }
    }

}