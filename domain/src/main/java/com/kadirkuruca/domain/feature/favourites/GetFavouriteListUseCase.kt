package com.kadirkuruca.domain.feature.favourites

import com.kadirkuruca.data.model.local.FavouriteMealEntity
import com.kadirkuruca.data.repository.FavouriteMealRepository
import javax.inject.Inject

class GetFavouriteListUseCase @Inject constructor(
    private val favouriteMealRepository: FavouriteMealRepository
) {
    suspend operator fun invoke(): List<FavouriteMealEntity> {
        return favouriteMealRepository.getFavouriteList()
    }
}