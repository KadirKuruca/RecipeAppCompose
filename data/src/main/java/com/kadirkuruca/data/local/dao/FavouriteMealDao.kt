package com.kadirkuruca.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.kadirkuruca.core.room.dao.BaseDao
import com.kadirkuruca.data.model.local.FavouriteMealEntity

@Dao
interface FavouriteMealDao: BaseDao<FavouriteMealEntity> {
    @Query("SELECT * FROM ${FavouriteMealEntity.TABLE_NAME}")
    suspend fun getFavouriteList(): List<FavouriteMealEntity>
}