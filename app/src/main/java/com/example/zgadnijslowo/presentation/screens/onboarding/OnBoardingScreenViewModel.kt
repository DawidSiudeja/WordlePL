package com.example.zgadnijslowo.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingScreenViewModel @Inject constructor(
    private val repository: Repository,
    private val appDatabase: AppDatabase
): ViewModel() {

    private val userInfoDao = appDatabase.userInfoDao()

    fun setOnBoardingState() {
        viewModelScope.launch {
            userInfoDao.setOnBoardingFinished()
        }
    }

}