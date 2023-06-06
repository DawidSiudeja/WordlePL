package com.example.zgadnijslowo.di

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.rememberNavController
import com.example.zgadnijslowo.data.remote.WordsApi
import com.example.zgadnijslowo.data.repository.RepositoryImpl
import com.example.zgadnijslowo.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWordsApi(): WordsApi {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .build()
            .create(WordsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(wordsApi: WordsApi): Repository {
        return RepositoryImpl(wordsApi)
    }


}