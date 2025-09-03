package com.example.userapp.domain.usecase

import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result
import com.example.userapp.domain.repository.UserRepository
import javax.inject.Inject

// Принцип SRP: Класс отвечает только за получение пользователей
class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Result<List<User>> {
        return userRepository.getUsers()
    }
}