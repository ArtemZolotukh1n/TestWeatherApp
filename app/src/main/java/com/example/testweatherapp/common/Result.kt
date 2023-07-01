package com.example.testweatherapp.common

/**
 * Sealed class representing different states of a result from an operation.
 * The operation could either be in 'Loading' state, yield 'Success' with data, or 'Error' with a message.
 */
sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}
