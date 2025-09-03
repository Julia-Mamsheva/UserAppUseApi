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
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi): UserRepository
    {
        return UserRepositoryImpl(userApi)
    }

    @Provides
    @Singleton
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }
}