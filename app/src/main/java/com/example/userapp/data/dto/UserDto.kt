package com.example.userapp.data.dto

// DTO для API ответа
data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)