package com.example.userapp.di

import com.example.userapp.data.remote.UserApi
import com.example.userapp.data.repository.UserRepositoryImpl
import com.example.userapp.domain.repository.UserRepository
import com.example.userapp.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Главный модуль зависимостей
@Module // Аннотация Dagger - указывает, что это модуль зависимостей
@InstallIn(SingletonComponent::class) // Область видимости - на всё время жизни приложения
object AppModule { // Object - singleton модуль

    // Предоставляет реализацию UserRepository
    @Provides // Указывает, что метод предоставляет зависимость
    @Singleton // Область видимости - singleton (один экземпляр на всё приложение)
    fun provideUserRepository(userApi: UserApi): UserRepository // Зависит от UserApi
    {
        return UserRepositoryImpl(userApi) // Возвращает реализацию
    }

    // Предоставляет UseCase
    @Provides
    @Singleton
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository) // Создаёт UseCase с репозиторием
    }
}