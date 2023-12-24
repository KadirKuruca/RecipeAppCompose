package com.kadirkuruca.data.model.remote.search

import com.kadirkuruca.data.model.remote.meal.Meal


data class SearchResponse(
    val meals: List<Meal>
)
