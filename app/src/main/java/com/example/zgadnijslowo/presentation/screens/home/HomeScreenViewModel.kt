package com.example.zgadnijslowo.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.repository.Repository
import com.example.zgadnijslowo.domain.model.UserInfo
import com.example.zgadnijslowo.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    useCases: UseCases
): ViewModel() {

    init {
        viewModelScope.launch {
            useCases.getAllWordsUseCase()
        }
    }

    private val userInfoDao = appDatabase.userInfoDao()

    fun getAllUserInfoData(): Flow<UserInfo> {
        return userInfoDao.getAllUserInfo()
    }

}