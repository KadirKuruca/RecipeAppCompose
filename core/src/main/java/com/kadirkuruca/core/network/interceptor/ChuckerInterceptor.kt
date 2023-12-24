package com.kadirkuruca.core.network.interceptor

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager

private const val CONTENT_LENGTH = 250_000L
fun createChuckerInterceptor(context: Context): ChuckerInterceptor {

    val chuckerCollector = ChuckerCollector(
        context = context,
        showNotification = true,
        retentionPeriod = RetentionManager.Period.ONE_HOUR
    )

    return ChuckerInterceptor.Builder(context)
        .collector(chuckerCollector)
        .maxContentLength(CONTENT_LENGTH)
        .redactHeaders("Auth-Token", "Bearer")
        .alwaysReadResponseBody(true)
        .build()
}