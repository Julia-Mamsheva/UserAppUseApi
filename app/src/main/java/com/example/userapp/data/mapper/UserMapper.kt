package com.example.userapp.data.mapper

import com.example.userapp.data.dto.UserDto
import com.example.userapp.domain.model.User

// Объявление объекта (Singleton)
object UserMapper {

    // Преобразование одного DTO в доменную модель
    fun toDomain(userDto: UserDto): User {
        return User(
            id = userDto.id,        // Прямое копирование ID
            name = userDto.name,    // Прямое копирование имени
            email = userDto.email,  // Прямое копирование email
            phone = userDto.phone   // Прямое копирование телефона
        )
    }

    // Преобразование списка DTO в список доменных моделей
    fun toDomainList(userDtos: List<UserDto>): List<User> {
        return userDtos.map { toDomain(it) }  // Использование функции map для преобразования каждого элемента
    }
}