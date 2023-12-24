package com.kadirkuruca.data.model.remote.mealdetail

import com.kadirkuruca.data.model.remote.meal.Meal


data class MealDetailResponse(
    val meals: List<Meal>
)