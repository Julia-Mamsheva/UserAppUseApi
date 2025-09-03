package com.example.userapp.di

import com.example.userapp.data.remote.UserApi
import com.example.userapp.data.remote.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Модуль для сетевых зависимостей
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return UserApiService.create()
    }
}