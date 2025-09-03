package com.example.userapp.data.mapper

import com.example.userapp.data.dto.UserDto
import com.example.userapp.domain.model.User

object UserMapper {
    fun toDomain(userDto: UserDto): User {
        return User(
            id = userDto.id,
            name = userDto.name,
            email = userDto.email,
            phone = userDto.phone
        )
    }

    fun toDomainList(userDtos: List<UserDto>): List<User> {
        return userDtos.map { toDomain(it) }
    }
}