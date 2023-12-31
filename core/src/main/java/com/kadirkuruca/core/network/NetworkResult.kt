package com.kadirkuruca.core.network

import retrofit2.HttpException

sealed class NetworkResult<T: Any> {
    class Success<T: Any>(val data: T): NetworkResult<T>()
    class Error<T: Any>(val code: Int, val message: String?): NetworkResult<T>()
    class Exception<T: Any>(val e: Throwable): NetworkResult<T>()
}

suspend fun <T: Any> handleApi(
    execute: suspend () -> retrofit2.Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(code = response.code(), response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}

suspend fun <T : Any> NetworkResult<T>.onSuccess(
    executable: suspend (T) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> NetworkResult<T>.onError(
    executable: suspend (code: Int, message: String?) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Error<T>) {
        executable(code, message)
    }
}

suspend fun <T : Any> NetworkResult<T>.onException(
    executable: suspend (e: Throwable) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Exception<T>) {
        executable(e)
    }
}
