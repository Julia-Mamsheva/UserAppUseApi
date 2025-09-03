package com.example.userapp.data.remote

import com.example.userapp.data.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

// Интерфейс API
interface UserApi { // Объявление интерфейса для HTTP-запросов

    // GET-запрос для получения списка пользователей
    @GET("users") // Аннотация Retrofit - указывает метод и endpoint
    suspend fun getUsers(): List<UserDto> // Suspend функция возвращает список DTO

    // GET-запрос для получения пользователя по ID
    @GET("users/{id}") // {id} - path parameter, который будет заменен
    suspend fun getUserById(@Path("id") id: Int): UserDto // @Path связывает параметр
}