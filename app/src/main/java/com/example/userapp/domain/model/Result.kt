package com.example.userapp.domain.model

// Sealed class для типобезопасного представления результата операции
sealed class Result<out T> { // out - ковариантность (можно использовать в производных классах)

    // Успешный результат с данными
    data class Success<out T>(val data: T) : Result<T>() // Содержит данные произвольного типа

    // Неуспешный результат с исключением
    data class Failure(val exception: Exception) : Result<Nothing>() // Nothing - не содержит данных
}