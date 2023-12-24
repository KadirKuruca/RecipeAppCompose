package com.kadirkuruca.data.repository

import com.kadirkuruca.data.local.dao.FavouriteMealDao
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FavouriteMealRepository @Inject constructor(
    private val dao: FavouriteMealDao
) {
    suspend fun getFavouriteList() = dao.getFavouriteList()
}