package com.example.userapp.domainTest

import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result
import com.example.userapp.domain.repository.UserRepository
import com.example.userapp.domain.usecase.GetUsersUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import kotlinx.coroutines.runBlocking
import java.io.IOException
import kotlin.test.assertTrue
import kotlin.test.assertEquals
import kotlin.test.assertSame

class GetUsersUseCaseTest {

    @Mock
    private lateinit var mockUserRepository: UserRepository

    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getUsersUseCase = GetUsersUseCase(mockUserRepository)
    }

    @Test
    fun InvokeShouldReturnSuccessWithUsersListWhenRepositorySucceeds() {
        runBlocking {
            // Arrange
            val expectedUsers = listOf(
                User(1, "John Doe", "john@example.com", "Developer"),
                User(2, "Jane Smith", "jane@example.com", "Designer")
            )

            `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(expectedUsers))

            // Act
            val result = getUsersUseCase()

            // Assert
            assertTrue(result is Result.Success)
            val users = (result as Result.Success).data
            assertEquals(2, users.size)
            assertEquals("John Doe", users[0].name)
            assertEquals("jane@example.com", users[1].email)

            // Verify that repository method was called
            verify(mockUserRepository).getUsers()
        }
    }

    @Test
    fun InvokeShouldReturnFailureWhenRepositoryFails() {
        runBlocking {
            // Arrange
            val expectedError = RuntimeException("Database error")
            `when`(mockUserRepository.getUsers()).thenReturn(Result.Failure(expectedError))

            // Act
            val result = getUsersUseCase()

            // Assert
            assertTrue(result is Result.Failure)
            assertEquals(expectedError, (result as Result.Failure).exception)
            assertEquals("Database error", result.exception.message)

            verify(mockUserRepository).getUsers()
        }
    }

    @Test
    fun InvokeShouldReturnEmptyListWhenRepositoryReturnsEmptyList() {
        runBlocking {
            // Arrange
            `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(emptyList()))

            // Act
            val result = getUsersUseCase()

            // Assert
            assertTrue(result is Result.Success)
            assertTrue((result as Result.Success).data.isEmpty())

            verify(mockUserRepository).getUsers()
        }
    }

    @Test
    fun `invoke should delegate call to repository exactly once`() {
        runBlocking {
            // Arrange
            val expectedUsers = listOf(User(1, "Test", "test@test.com", "Test"))
            `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(expectedUsers))

            // Act
            val result = getUsersUseCase()

            // Assert
            assertTrue(result is Result.Success)

            // Verify that repository method was called exactly once
            verify(mockUserRepository).getUsers()
        }
    }
    @Test
    fun `invoke should not modify repository response`() = runBlocking {
        // Arrange
        val originalUsers = listOf(
            User(1, "Original", "original@test.com", "Original Job")
        )
        `when`(mockUserRepository.getUsers()).thenReturn(Result.Success(originalUsers))

        // Act
        val result = getUsersUseCase()

        // Assert
        assertTrue(result is Result.Success)
        val returnedUsers = (result as Result.Success).data

        // Use case не должен изменять данные из репозитория
        assertSame(originalUsers, returnedUsers) // Проверяем, что это тот же объект
        assertEquals("Original", returnedUsers[0].name)
    }

    @Test
    fun `invoke should handle different result types from repository`() = runBlocking {
        // Arrange - тестируем разные сценарии
        val testCases = listOf(
            Result.Success(emptyList<User>()),
            Result.Success(listOf(User(1, "Single", "single@test.com", "Single"))),
            Result.Failure(IOException("Network error")),
            Result.Failure(IllegalStateException("Invalid state"))
        )

        testCases.forEach { expectedResult ->
            `when`(mockUserRepository.getUsers()).thenReturn(expectedResult)

            // Act
            val actualResult = getUsersUseCase()

            // Assert
            when (expectedResult) {
                is Result.Success -> {
                    assertTrue(actualResult is Result.Success)
                    assertEquals(expectedResult.data, (actualResult as Result.Success).data)
                }
                is Result.Failure -> {
                    assertTrue(actualResult is Result.Failure)
                    assertEquals(expectedResult.exception.message, (actualResult as Result.Failure).exception.message)
                }
            }
        }
    }
}