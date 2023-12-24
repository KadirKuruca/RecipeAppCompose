package com.kadirkuruca.data.remote.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.kadirkuruca.core.network.NetworkConfig
import com.kadirkuruca.core.network.createOkHttpClient
import com.kadirkuruca.core.network.createRetrofit
import com.kadirkuruca.core.network.interceptor.createChuckerInterceptor
import com.kadirkuruca.core.network.interceptor.createHttpLoggingInterceptor
import com.kadirkuruca.data.remote.service.MealService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    @Named(value = BASE_URL)
    fun provideBaseUrl(networkConfig: NetworkConfig) = networkConfig.baseUrl()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(networkConfig: NetworkConfig): HttpLoggingInterceptor {
        return createHttpLoggingInterceptor(isDev = networkConfig.isDev())
    }

    @Provides
    @Singleton
    fun provideChuckInterceptor(@ApplicationContext context: Context): ChuckerInterceptor = createChuckerInterceptor(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        return createOkHttpClient(
            interceptors = arrayOf(
                httpLoggingInterceptor,
                chuckerInterceptor
            ),
            context
        )
    }

    @Provides
    @Singleton
    fun provideMealService(
        @Named(value = BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient
    ): MealService {
        return createRetrofit(
            baseUrl,
            okHttpClient,
            CoroutineScope(Dispatchers.IO)
        )
    }

    companion object {
        const val BASE_URL = "base_url"
    }
}