package com.kadirkuruca.data.remote.service

import com.kadirkuruca.core.network.NetworkResult
import com.kadirkuruca.data.model.remote.category.CategoryResponse
import com.kadirkuruca.data.model.remote.filteredmeal.FilteredMealResponse
import com.kadirkuruca.data.model.remote.mealdetail.MealDetailResponse
import com.kadirkuruca.data.model.remote.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {
    @GET(MEAL_DETAILS)
    suspend fun getMealDetails(
        @Query("i") mealId: String
    ): NetworkResult<MealDetailResponse>

    @GET(CATEGORIES)
    suspend fun getCategories(): NetworkResult<CategoryResponse>

    @GET(SEARCH)
    suspend fun search(
        @Query("s") searchString: String
    ): NetworkResult<SearchResponse>

    @GET(FILTER)
    suspend fun getMealsByRandomCategory(
        @Query("c") category: String
    ): NetworkResult<FilteredMealResponse>

    companion object {
        const val MEAL_DETAILS = "lookup.php"
        const val CATEGORIES = "categories.php"
        const val SEARCH = "search.php"
        const val FILTER = "filter.php"
    }
}