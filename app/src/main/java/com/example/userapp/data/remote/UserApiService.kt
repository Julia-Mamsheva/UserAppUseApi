package com.example.userapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Принцип SRP: Класс отвечает только за создание API сервиса
object UserApiService { // Singleton - единственная точка создания API

    // Базовая константа URL
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Фабричный метод для создания API
    fun create(): UserApi { // Возвращает интерфейс UserApi
        // Создание и настройка HTTP-клиента
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY // Логирование запросов/ответов
            })
            .build()

        // Построение Retrofit клиента
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // Базовый URL
            .client(okHttpClient) // Установка кастомного клиента
            .addConverterFactory(GsonConverterFactory.create()) // Конвертер JSON→объекты
            .build()

        // Создание реализации интерфейса
        return retrofit.create(UserApi::class.java)
    }
}