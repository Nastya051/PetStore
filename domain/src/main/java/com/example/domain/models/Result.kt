package com.example.domain.models

sealed class Result {
    data class Success<T>(val value: T) : Result()
    data class Error(val value: CommonResponse) : Result()
    data class ErrorNetwork(val value: Exception) : Result()
}