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
@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _usersState = mutableStateOf<List<User>>(emptyList())
    val usersState: State<List<User>> = _usersState

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    private val _errorState = mutableStateOf<String?>(null)
    val errorState: State<String?> = _errorState

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _loadingState.value = true
            _errorState.value = null

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

    fun clearError() {
        _errorState.value = null
    }
}