package com.example.userapp

import com.example.userapp.data.dto.UserDto
import com.example.userapp.data.mapper.UserMapper
import org.junit.Test
import kotlin.test.assertEquals

class UserMapperTest {

    @Test
    fun toDomainShouldConvertUserDtoToUserCorrectly() {
        // Arrange
        val userDto = UserDto(1, "John Doe", "john@example.com", "+79099099999")

        // Act
        val user = UserMapper.toDomain(userDto)

        // Assert
        assertEquals(1, user.id)
        assertEquals("John Doe", user.name)
        assertEquals("john@example.com", user.email)
        assertEquals("+79099099999", user.phone)
    }

    @Test
    fun toDomainListShouldConvertListOfUserDtoToUserCorrectly() {
        // Arrange
        val userDtos = listOf(
            UserDto(1, "John Doe", "john@example.com", "79099099999"),
            UserDto(2, "Jane Smith", "jane@example.com", "79099099991")
        )

        // Act
        val users = UserMapper.toDomainList(userDtos)

        // Assert
        assertEquals(2, users.size)
        assertEquals("John Doe", users[0].name)
        assertEquals("79099099991", users[1].phone)
    }


    // В UserDTO должены быть поля с допустимым значением null "?"
/*    @Test
    fun toDomainShouldHandleNullValuesGracefully() {
        // Arrange
        val userDto = UserDto(1, null, null, null)

        // Act
        val user = UserMapper.toDomain(userDto)

        // Assert
        assertEquals(1, user.id)
        assertEquals("", user.name) // или проверка на default values
        assertEquals("", user.email)
        assertEquals("", user.phone)
    }*/
}