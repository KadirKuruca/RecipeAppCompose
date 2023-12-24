package com.kadirkuruca.data.local.di

import android.content.Context
import androidx.room.Room
import com.kadirkuruca.data.BuildConfig
import com.kadirkuruca.data.local.db.RecipeAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "dbName"

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDbName() = BuildConfig.DATABASE_NAME

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbName: String,
        @ApplicationContext context: Context
    ): RecipeAppDatabase {
        return Room.databaseBuilder(context, RecipeAppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavouriteMealDao(database: RecipeAppDatabase) = database.favouriteMealDao()
}