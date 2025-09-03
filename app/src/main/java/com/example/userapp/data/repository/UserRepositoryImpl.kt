package com.example.userapp.data.repository

import com.example.userapp.data.mapper.UserMapper
import com.example.userapp.data.remote.UserApi
import com.example.userapp.domain.model.Result
import com.example.userapp.domain.model.User
import com.example.userapp.domain.repository.UserRepository
import javax.inject.Inject

// Принцип DIP: Реализация зависит от абстракции
class UserRepositoryImpl @Inject constructor( // Внедрение зависимости через конструктор
    private val userApi: UserApi // Зависимость от абстракции, а не конкретной реализации
) : UserRepository { // Реализация абстрактного интерфейса

    override suspend fun getUsers(): Result<List<User>> { // Возврат обёртки Result
        return try {
            val usersDto = userApi.getUsers() // Вызов API (абстракция)
            val users = UserMapper.toDomainList(usersDto) // Преобразование в доменную модель
            Result.Success(users) // Возврат успешного результата
        } catch (e: Exception) {
            Result.Failure(e) // Возврат ошибки в обёртке
        }
    }

    override suspend fun getUserById(id: Int): Result<User> {
        return try {
            val userDto = userApi.getUserById(id) // Запрос конкретного пользователя
            val user = UserMapper.toDomain(userDto) // Преобразование одного объекта
            Result.Success(user)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}