package com.kadirkuruca.data.repository

import com.kadirkuruca.data.remote.service.MealService
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MealRepository @Inject constructor(
    private val service: MealService
) {
    suspend fun getMealDetails(mealId: String) = service.getMealDetails(mealId)
    suspend fun searchMeal(searchString: String) = service.search(searchString)
}