package com.example.userapp.domain.repository

import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result

// Принцип DIP: Абстракция не зависит от деталей
interface UserRepository {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUserById(id: Int): Result<User>
}