package com.example.userapp

import com.example.userapp.data.remote.UserApi
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After


import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.Test

class UserApiTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var userApi: UserApi

    @Before
    fun setup() {
        // Создаем MockWebServer для имитации HTTP запросов
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Создаем Retrofit клиент, который будет обращаться к mock серверу
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // Используем URL mock сервера
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
    }

    @After
    fun tearDown() {
        // Останавливаем mock сервер после каждого теста
        mockWebServer.shutdown()
    }

    @Test
    fun getUsersShouldReturnListOfUsersWhenSuccessful() {
        // Arrange - подготавливаем mock ответ
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""
                [
                    {"id": 1, "name": "John Doe", "email": "john@example.com"},
                    {"id": 2, "name": "Jane Smith", "email": "jane@example.com"}
                ]
            """.trimIndent())

        mockWebServer.enqueue(mockResponse)

        // Act - выполняем запрос
        val response = runBlocking { userApi.getUsers() }

        // Assert - проверяем результаты
        assertEquals(2, response.size)
        assertEquals("John Doe", response[0].name)
        assertEquals("jane@example.com", response[1].email)
    }

    @Test
    fun getUserByIdShouldReturnUserWhenFound() {
        // Arrange
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""
                [
                    {"id": 1, "name": "John Doe", "email": "john@example.com"},
                    {"id": 2, "name": "Jane Smith", "email": "jane@example.com"}
                ]
            """.trimIndent())

        mockWebServer.enqueue(mockResponse)

        // Act
        val response = runBlocking { userApi.getUsers().first({it.id==1}) }

        // Assert
        assertEquals(2, response.id)
        assertEquals("Jane Smith", response.name)
    }
}