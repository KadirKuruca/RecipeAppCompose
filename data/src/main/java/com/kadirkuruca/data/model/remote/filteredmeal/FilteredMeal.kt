package com.kadirkuruca.data.model.remote.filteredmeal

data class FilteredMeal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
) {
    companion object {
        fun getTestFilteredMealList(): ArrayList<FilteredMeal> {
            val list = arrayListOf<FilteredMeal>()
            list.add(
                FilteredMeal(
                    "1234",
                    "Baked Salmon with Fennel & Tomatoes",
                    "https://www.themealdb.com/images/media/meals/1548772327.jpg")
            )
            list.add(
                FilteredMeal(
                    "12345",
                    "Baked Salmon with Fennel & Tomatoes",
                    "https://www.themealdb.com/images/media/meals/1548772327.jpg")
            )
            list.add(
                FilteredMeal(
                    "123456",
                    "Baked Salmon with Fennel & Tomatoes & Tomatoes",
                    "https://www.themealdb.com/images/media/meals/1548772327.jpg")
            )
            list.add(
                FilteredMeal(
                    "123457",
                    "Baked Salmon with Fennel & Tomatoes",
                    "https://www.themealdb.com/images/media/meals/1548772327.jpg")
            )
            return list
        }
    }
}