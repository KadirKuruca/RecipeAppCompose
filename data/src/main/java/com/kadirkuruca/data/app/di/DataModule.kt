package com.kadirkuruca.data.app.di

import com.kadirkuruca.core.network.NetworkConfig
import com.kadirkuruca.data.app.DataNetworkConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig {
        return DataNetworkConfig()
    }
}