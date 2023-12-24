package com.kadirkuruca.core.network.interceptor

import okhttp3.logging.HttpLoggingInterceptor

fun createHttpLoggingInterceptor(isDev: Boolean = true): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = if (isDev) {
            HttpLoggingInterceptor.Level.BODY
        }
        else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}