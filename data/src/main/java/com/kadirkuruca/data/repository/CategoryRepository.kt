package com.kadirkuruca.data.repository

import com.kadirkuruca.data.remote.service.MealService
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CategoryRepository @Inject constructor(
    private val service: MealService
) {
    suspend fun getCategories() = service.getCategories()
    suspend fun getMealsByRandomCategory(category: String) = service.getMealsByRandomCategory(category)
}