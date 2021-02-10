package com.sm.lecture5.data

sealed class State<out T> {
    data class Success<out T>(val result: T? = null): State<T>()
    data class ServerError(val message: String? = null): State<Nothing>()
    object NetworkError: State<Nothing>()
    object UnknownError: State<Nothing>()
    object Loading: State<Nothing>()
}