package com.kadirkuruca.data.app

import com.kadirkuruca.core.network.NetworkConfig
import com.kadirkuruca.data.BuildConfig

class DataNetworkConfig: NetworkConfig() {
    override fun baseUrl() = BuildConfig.BASE_URL
    override fun isDev() = BuildConfig.DEBUG
}