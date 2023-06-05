package com.example.zgadnijslowo.domain.model

import android.provider.UserDictionary.Words

data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val words: List<Words> = emptyList()
)
