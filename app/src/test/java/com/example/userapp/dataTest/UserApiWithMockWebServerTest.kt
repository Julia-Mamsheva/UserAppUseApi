package com.example.userapp.dataTest

import com.example.userapp.data.remote.UserApi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.runBlocking
import kotlin.test.assertEquals

class UserApiWithMockWebServerTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var userApi: UserApi

    @Before
    fun setup() {
        // Инициализация MockWebServer
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Создание Retrofit клиента, указывающего на MockWebServer
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/")) // Важно: используем URL mock сервера
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
    }

    @After
    fun tearDown() {
        // Обязательно останавливаем сервер после тестов
        mockWebServer.shutdown()
    }

    @Test
    fun testGetUsersWithMockResponse() = runBlocking {
        // Arrange - подготавливаем mock ответ
        val mockResponseBody = """
            [
                {"id": 1, "name": "John Doe", "email": "john@example.com", "job": "Developer"},
                {"id": 2, "name": "Jane Smith", "email": "jane@example.com", "job": "Designer"}
            ]
        """.trimIndent()

        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(mockResponseBody)
            .addHeader("Content-Type", "application/json")

        mockWebServer.enqueue(mockResponse)

        // Act - выполняем запрос
        val users = userApi.getUsers()

        // Assert - проверяем результаты
        assertEquals(2, users.size)
        assertEquals("John Doe", users[0].name)
        assertEquals("jane@example.com", users[1].email)

        // Дополнительно: проверяем что запрос был сделан корректно
        val request = mockWebServer.takeRequest()
        assertEquals("/users", request.path)
        assertEquals("GET", request.method)
    }

    @Test
    fun testGetUserByIdWith404Error() = runBlocking {
        // Arrange - имитируем ошибку 404
        val mockResponse = MockResponse()
            .setResponseCode(404)
            .setBody("Not Found")

        mockWebServer.enqueue(mockResponse)

        // Act & Assert - ожидаем исключение
        try {
            userApi.getUserById(999)
            assert(false) // Не должно дойти до этой строки
        } catch (e: Exception) {
            // Ожидаем, что будет выброшено исключение
            assert(true)
        }
    }
}


