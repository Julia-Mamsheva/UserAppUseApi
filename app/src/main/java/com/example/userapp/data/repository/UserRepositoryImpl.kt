package com.example.userapp.data.repository

import com.example.userapp.data.mapper.UserMapper
import com.example.userapp.data.remote.UserApi
import com.example.userapp.domain.model.Result
import com.example.userapp.domain.model.User
import com.example.userapp.domain.repository.UserRepository
import javax.inject.Inject

// Принцип DIP: Реализация зависит от абстракции
class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun getUsers(): Result<List<User>> {
        return try {
            val usersDto = userApi.getUsers()
            val users = UserMapper.toDomainList(usersDto)
            Result.Success(users)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }

    override suspend fun getUserById(id: Int): Result<User> {
        return try {
            val userDto = userApi.getUserById(id)
            val user = UserMapper.toDomain(userDto)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}