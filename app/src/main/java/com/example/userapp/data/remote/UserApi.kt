package com.example.userapp.data.remote

import com.example.userapp.data.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

// Интерфейс API
interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserDto
}