package com.example.zgadnijslowo.presentation.screens.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.domain.repository.Repository
import com.example.zgadnijslowo.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingScreenViewModel @Inject constructor(
    private val repository: Repository,
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