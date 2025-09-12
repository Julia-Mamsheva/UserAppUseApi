package com.example.userapp.domainTest

import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result
import com.example.userapp.domain.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlinx.coroutines.runBlocking
import kotlin.test.assertTrue
import kotlin.test.assertEquals

class UserRepositoryTest {

    // Мок реализации интерфейса
    @Mock
    private lateinit var mockUserRepository: UserRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getUserShouldReturnSuccessWithUsersListWhenSuccessful() = runBlocking {
        // Arrange
        val expectedUsers = listOf(
            User(1, "John Doe", "john@example.com", "Developer"),
            User(2, "Jane Smith", "jane@example.com", "Designer")
        )

        // Настраиваем мок: при вызове getUsers возвращаем Success
        `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(expectedUsers))

        // Act
        val result = mockUserRepository.getUsers()

        // Assert
        assertTrue(result is Result.Success)
        val users = (result as Result.Success).data
        assertEquals(2, users.size)
        assertEquals("John Doe", users[0].name)
        assertEquals("jane@example.com", users[1].email)
    }

    @Test
    fun getUsersShouldReturnFailureEhenErrorOccurs() = runBlocking {
        // Arrange
        val expectedError = RuntimeException("Network error")

        // Настраиваем мок: при вызове getUsers возвращаем Failure
        `when`(mockUserRepository.getUsers()).thenReturn(Result.Failure(expectedError))

        // Act
        val result = mockUserRepository.getUsers()

        // Assert
        assertTrue(result is Result.Failure)
        assertEquals(expectedError, (result as Result.Failure).exception)
        assertEquals("Network error", result.exception.message)
    }

    @Test
    fun getUsersShouldReturnEmptyListWhenNoUsersFound() = runBlocking {
        // Arrange
        `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(emptyList()))

        // Act
        val result = mockUserRepository.getUsers()

        // Assert
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun getUserByIdShouldReturnSuccessWithUserWhenFound() = runBlocking {
        // Arrange
        val expectedUser = User(1, "John Doe", "john@example.com", "Developer")
        `when`(mockUserRepository.getUserById(1)).thenReturn(Result.Success(expectedUser))

        // Act
        val result = mockUserRepository.getUserById(1)

        // Assert
        assertTrue(result is Result.Success)
        assertEquals("John Doe", (result as Result.Success).data.name)
        assertEquals("john@example.com", result.data.email)
    }

    @Test
    fun getUserByIdShouldReturnFailureWhenUserNotFound() = runBlocking {
        // Arrange
        val expectedError = RuntimeException("User not found")
        `when`(mockUserRepository.getUserById(999)).thenReturn(Result.Failure(expectedError))

        // Act
        val result = mockUserRepository.getUserById(999)

        // Assert
        assertTrue(result is Result.Failure)
        assertEquals("User not found", (result as Result.Failure).exception.message)
    }

    @Test
    fun getUserByIdShouldHandleDifferentIDsCorrectly() = runBlocking {
        // Arrange
        val user1 = User(1, "User One", "user1@test.com", "Job1")
        val user2 = User(2, "User Two", "user2@test.com", "Job2")

        `when`(mockUserRepository.getUserById(1)).thenReturn(Result.Success(user1))
        `when`(mockUserRepository.getUserById(2)).thenReturn(Result.Success(user2))

        // Act & Assert для разных ID
        val result1 = mockUserRepository.getUserById(1)
        val result2 = mockUserRepository.getUserById(2)

        assertTrue(result1 is Result.Success)
        assertTrue(result2 is Result.Success)
        assertEquals("User One", (result1 as Result.Success).data.name)
        assertEquals("User Two", (result2 as Result.Success).data.name)
    }
}