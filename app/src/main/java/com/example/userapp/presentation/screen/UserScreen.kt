package com.example.userapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.userapp.presentation.viewmodel.UserViewModel

// Принцип ISP: Интерфейсы разделены на мелкие специфические
@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel() // Внедрение ViewModel через Hilt
) {
    // Подписка на состояния ViewModel
    val users by viewModel.usersState
    val loading by viewModel.loadingState
    val error by viewModel.errorState

    // Основной layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "Users",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Индикатор загрузки
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }

        // Отображение ошибки
        error?.let { errorMessage ->
            ErrorMessage(
                message = errorMessage,
                onRetry = { viewModel.loadUsers() },
                onDismiss = { viewModel.clearError() }
            )
        }

        // Список пользователей
        LazyColumn {
            items(users) { user ->
                Text(user.name) // Отображение имени пользователя
            }
        }
    }
}

// Отдельный компонент для отображения ошибки
@Composable
fun ErrorMessage(
    message: String,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Error") },
        text = { Text(message) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text("Retry")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Dismiss")
            }
        }
    )
}