package com.example.zgadnijslowo.di

import GetAllWordsUseCase
import com.example.zgadnijslowo.data.local.AppDatabase
import com.example.zgadnijslowo.data.local.dao.WordsDao
import com.example.zgadnijslowo.data.remote.WordsApi
import com.example.zgadnijslowo.data.repository.RemoteDataSourceImpl
import com.example.zgadnijslowo.data.repository.Repository
import com.example.zgadnijslowo.domain.repository.RemoteDataSource
import com.example.zgadnijslowo.domain.use_cases.UseCases
import com.google.gson.Gson
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.sql.Time
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideWordsApi(retrofit: Retrofit): WordsApi {
        return retrofit.create(WordsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWordsDao(appDatabase: AppDatabase): WordsDao {
        return appDatabase.wordsDao()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(wordsApi: WordsApi, appDatabase: AppDatabase): RemoteDataSource {
        return RemoteDataSourceImpl(wordsApi, appDatabase)
    }


    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllWordsUseCase = GetAllWordsUseCase(repository)
        )
    }




}