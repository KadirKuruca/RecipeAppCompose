package com.kadirkuruca.data.repository.di

import com.kadirkuruca.data.local.dao.FavouriteMealDao
import com.kadirkuruca.data.remote.service.MealService
import com.kadirkuruca.data.repository.CategoryRepository
import com.kadirkuruca.data.repository.FavouriteMealRepository
import com.kadirkuruca.data.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCategoryRepository(service: MealService) = CategoryRepository(service)

    @Singleton
    @Provides
    fun provideFavouritesRepository(dao: FavouriteMealDao) = FavouriteMealRepository(dao)

    @Singleton
    @Provides
    fun provideMealRepository(service: MealService) = MealRepository(service)
}