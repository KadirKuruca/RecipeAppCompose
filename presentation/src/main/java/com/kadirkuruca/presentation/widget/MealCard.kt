package com.kadirkuruca.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kadirkuruca.data.model.remote.filteredmeal.FilteredMeal
import com.kadirkuruca.presentation.theme.AppTypography
import com.kadirkuruca.presentation.theme.RecipeAppColors
import com.kadirkuruca.presentation.theme.RecipeAppComposeTheme
import com.kadirkuruca.presentation.theme.cardBackgroundColor

@Composable
fun MealCard(
    modifier: Modifier = Modifier,
    mealDto: FilteredMeal
) {
    ElevatedCard (
        modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = RecipeAppColors.cardBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ){
        AsyncImage(
            model = mealDto.strMealThumb,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
        )
        Text(
            text = mealDto.strMeal,
            style = AppTypography.h5,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MealCardPreview() {
    RecipeAppComposeTheme {
        MealCard(mealDto = FilteredMeal.getTestFilteredMealList().first())
    }
}