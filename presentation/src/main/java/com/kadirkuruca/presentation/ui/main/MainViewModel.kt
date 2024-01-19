package com.kadirkuruca.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kadirkuruca.core.network.onError
import com.kadirkuruca.core.network.onException
import com.kadirkuruca.core.network.onSuccess
import com.kadirkuruca.data.repository.MealRepository
import com.kadirkuruca.domain.feature.favourites.GetFavouriteListUseCase
import com.kadirkuruca.domain.feature.meal.GetMealDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mealRepository: MealRepository,
    private val getFavouriteListUseCase: GetFavouriteListUseCase,
    private val getMealDetailUseCase: GetMealDetailUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            val response = getMealDetailUseCase("52959")
            response.onSuccess {
                println(it.toString())
            }.onError { code, message ->
                println(message.toString())
            }.onException {
                println(it.message)
            }
        }
    }
}