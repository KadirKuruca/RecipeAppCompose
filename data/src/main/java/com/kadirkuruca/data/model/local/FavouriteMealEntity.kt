package com.kadirkuruca.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kadirkuruca.data.model.local.FavouriteMealEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class FavouriteMealEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_MEAL_ID) val mealId: String,
    @ColumnInfo(name = COLUMN_MEAL_NAME) val mealName: String,
    @ColumnInfo(name = COLUMN_MEAL_THUMB) val mealThumb: String
)
{
    companion object {
        const val TABLE_NAME = "meal_favourite"
        const val COLUMN_ID = "id"
        const val COLUMN_MEAL_ID = "mealId"
        const val COLUMN_MEAL_NAME = "mealName"
        const val COLUMN_MEAL_THUMB = "mealThumb"
    }
}

