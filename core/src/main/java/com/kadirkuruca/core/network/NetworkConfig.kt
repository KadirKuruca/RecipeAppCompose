package com.kadirkuruca.core.network

abstract class NetworkConfig {
    abstract fun baseUrl(): String
    open fun isDev() = false
}