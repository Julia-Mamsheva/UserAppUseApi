package com.example.userapp.domain.repository

import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result

// Принцип DIP: Абстракция не зависит от деталей
interface UserRepository { // Абстракция - высокоуровневый контракт

    // Приостанавливающая функция для получения списка пользователей
    suspend fun getUsers(): Result<List<User>> // Возвращает обёрнутый результат

    // Приостанавливающая функция для получения пользователя по ID
    suspend fun getUserById(id: Int): Result<User> // Параметр id, возврат Result<User>
}