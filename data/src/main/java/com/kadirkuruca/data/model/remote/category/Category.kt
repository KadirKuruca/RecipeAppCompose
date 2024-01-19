package com.kadirkuruca.data.model.remote.category

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String,
) {
    companion object {
        fun getTestCategories(): ArrayList<Category> {
            return arrayListOf(
                Category(
                    idCategory = "1",
                    strCategory = "Beef",
                    strCategoryThumb = "https://www.themealdb.com/images/category/beef.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "2",
                    strCategory = "Chicken",
                    strCategoryThumb = "https://www.themealdb.com/images/category/chicken.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "3",
                    strCategory = "Dessert",
                    strCategoryThumb = "https://www.themealdb.com/images/category/dessert.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "4",
                    strCategory = "Beef",
                    strCategoryThumb = "https://www.themealdb.com/images/category/beef.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "5",
                    strCategory = "Chicken",
                    strCategoryThumb = "https://www.themealdb.com/images/category/chicken.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "6",
                    strCategory = "Dessert",
                    strCategoryThumb = "https://www.themealdb.com/images/category/dessert.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "7",
                    strCategory = "Beef",
                    strCategoryThumb = "https://www.themealdb.com/images/category/beef.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "8",
                    strCategory = "Chicken",
                    strCategoryThumb = "https://www.themealdb.com/images/category/chicken.png",
                    strCategoryDescription = ""
                ),
                Category(
                    idCategory = "9",
                    strCategory = "Dessert",
                    strCategoryThumb = "https://www.themealdb.com/images/category/dessert.png",
                    strCategoryDescription = ""
                )
            )
        }
    }
}