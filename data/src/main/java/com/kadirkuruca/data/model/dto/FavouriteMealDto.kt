package com.kadirkuruca.data.model.dto

import com.kadirkuruca.data.model.local.FavouriteMealEntity

data class FavouriteMealDto(
    val id: Int,
    val mealId: String,
    val mealName: String,
    val mealThumb: String
)

fun FavouriteMealDto.toEntity() = FavouriteMealEntity(
    id = id,
    mealId = mealId,
    mealName = mealName,
    mealThumb = mealThumb
)

fun FavouriteMealEntity.toDto() = FavouriteMealDto(
    id = id,
    mealId = mealId,
    mealName = mealName,
    mealThumb = mealThumb
)

fun List<FavouriteMealDto>.toEntityList() = map { it.toEntity() }
fun List<FavouriteMealEntity>.toDtoList() = map { it.toDto() }
