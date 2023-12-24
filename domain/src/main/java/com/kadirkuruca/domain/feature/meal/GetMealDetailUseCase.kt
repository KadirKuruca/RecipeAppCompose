package com.kadirkuruca.domain.feature.meal

import com.kadirkuruca.core.network.NetworkResult
import com.kadirkuruca.data.model.remote.mealdetail.MealDetailResponse
import com.kadirkuruca.data.repository.MealRepository
import javax.inject.Inject

class GetMealDetailUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    suspend operator fun invoke(mealId: String): NetworkResult<MealDetailResponse> {
        return mealRepository.getMealDetails(mealId)
    }
}