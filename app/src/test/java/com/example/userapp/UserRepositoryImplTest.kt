package com.example.userapp

import com.example.userapp.data.dto.UserDto
import com.example.userapp.domain.model.Result
import com.example.userapp.data.remote.UserApi
import com.example.userapp.data.repository.UserRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRepositoryImplTest {

    @Mock
    private lateinit var mockUserApi: UserApi

    private lateinit var userRepository: UserRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        userRepository = UserRepositoryImpl(mockUserApi)
    }

    @Test
    fun GetUsersShouldReturnSuccessWithUsersWhenAPICallSucceeds() = runBlocking {
        // Arrange
        val userDtos = listOf(
            UserDto(1, "John Doe", "john@example.com", "Developer"),
            UserDto(2, "Jane Smith", "jane@example.com", "Designer")
        )

        `when`(mockUserApi.getUsers()).thenReturn(userDtos)

        // Act
        val result = userRepository.getUsers()

        // Assert
        assertTrue(result is Result.Success)
        val users = (result as Result.Success).data
        assertEquals(2, users.size)
        assertEquals("John Doe", users[0].name)
    }

    @Test
    fun getUsersShouldReturnFailureWhenAPICallThrowsException() = runBlocking {
        // Arrange
        val exception = RuntimeException("Network error")
        `when`(mockUserApi.getUsers()).thenThrow(exception)

        // Act
        val result = userRepository.getUsers()

        // Assert
        assertTrue(result is Result.Failure)
        assertEquals(exception, (result as Result.Failure).exception)
    }

    @Test
    fun getUserByIdShouldReturnSuccessWithUserWhenFound() = runBlocking {
        // Arrange
        val userDto = UserDto(1, "John Doe", "john@example.com", "Developer")
        `when`(mockUserApi.getUserById(1)).thenReturn(userDto)

        // Act
        val result = userRepository.getUserById(1)

        // Assert
        assertTrue(result is Result.Success)
        val user = (result as Result.Success).data
        assertEquals("John Doe", user.name)
    }

    @Test
    fun getUserByIdShouldReturnFailureWhenUserNotFound() = runBlocking {
        // Arrange
        val exception = RuntimeException("User not found")
        `when`(mockUserApi.getUserById(999)).thenThrow(exception)

        // Act
        val result = userRepository.getUserById(999)

        // Assert
        assertTrue(result is Result.Failure)
        assertEquals(exception, (result as Result.Failure).exception)
    }
}