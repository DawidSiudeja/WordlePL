package com.example.zgadnijslowo.domain.use_cases

import GetAllWordsUseCase
import com.example.zgadnijslowo.domain.use_cases.get_random_word.GetRandomWordFromApi

data class UseCases(
    val getAllWordsUseCase: GetAllWordsUseCase,
    val getRandomWordFromApi: GetRandomWordFromApi
)