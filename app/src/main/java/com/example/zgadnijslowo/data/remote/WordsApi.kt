package com.example.zgadnijslowo.data.remote

import com.example.zgadnijslowo.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WordsApi {

    @GET("words/all")
    suspend fun getAllWords(): ApiResponse

    @GET("words/search")
    suspend fun searchWord(
        @Query("query") query: String
    ): ApiResponse

    @GET("words/random")
    suspend fun getRandomWord(
        @Query("letters") letters: String
    ): ApiResponse

}