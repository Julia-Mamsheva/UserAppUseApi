package com.example.userapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.domain.usecase.GetUsersUseCase
import com.example.userapp.domain.model.User
import com.example.userapp.domain.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Принцип OCP: Класс открыт для расширения, но закрыт для модификации
@HiltViewModel // Аннотация Hilt для внедрения зависимостей
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase // Внедрение UseCase
) : ViewModel() { // Наследование от Android ViewModel

    // Приватное mutable состояние и публичное immutable состояние
    private val _usersState = mutableStateOf<List<User>>(emptyList())
    val usersState: State<List<User>> = _usersState

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    private val _errorState = mutableStateOf<String?>(null)
    val errorState: State<String?> = _errorState

    // Инициализация - загрузка данных при создании ViewModel
    init {
        loadUsers()
    }

    // Публичная функция для загрузки пользователей
    fun loadUsers() {
        viewModelScope.launch { // Запуск корутины в scope ViewModel
            _loadingState.value = true
            _errorState.value = null

            // Обработка результата UseCase
            when (val result = getUsersUseCase()) {
                is Result.Success -> {
                    _usersState.value = result.data
                }
                is Result.Failure -> {
                    _errorState.value = result.exception.message ?: "Unknown error"
                }
            }

            _loadingState.value = false
        }
    }

    // Функция для очистки ошибки
    fun clearError() {
        _errorState.value = null
    }
}