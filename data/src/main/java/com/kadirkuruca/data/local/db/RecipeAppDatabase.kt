package com.kadirkuruca.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kadirkuruca.data.local.dao.FavouriteMealDao
import com.kadirkuruca.data.model.local.FavouriteMealEntity

@Database(
    entities = [FavouriteMealEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeAppDatabase: RoomDatabase() {
    abstract fun favouriteMealDao(): FavouriteMealDao
}