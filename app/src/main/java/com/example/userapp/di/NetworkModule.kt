package com.example.userapp.di

import com.example.userapp.data.remote.UserApi
import com.example.userapp.data.remote.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Модуль для сетевых зависимостей
@Module // Аннотация Dagger модуля
@InstallIn(SingletonComponent::class) // Область видимости - singleton
object NetworkModule { // Singleton объект

    // Провайдер для UserApi
    @Provides // Метод предоставляет зависимость
    @Singleton // Один экземпляр на всё приложение
    fun provideUserApi(): UserApi { // Возвращает интерфейс UserApi
        return UserApiService.create() // Делегирует создание сервису
    }
}