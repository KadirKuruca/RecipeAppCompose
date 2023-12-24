package com.kadirkuruca.core.network

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CLIENT_TIME_OUT = 60L
fun createOkHttpClient(
    vararg interceptors: Interceptor,
    context: Context
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        interceptors.forEach { addInterceptor(it) }
        connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
    }.build()
}

inline fun <reified T> createRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    coroutineScope: CoroutineScope
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(NetworkResultCallAdapterFactory.create(coroutineScope))
        .build()
    return retrofit.create(T::class.java)
}