package com.kadirkuruca.presentation.widget

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kadirkuruca.data.model.remote.category.Category
import com.kadirkuruca.presentation.theme.AppTypography
import com.kadirkuruca.presentation.theme.RecipeAppColors
import com.kadirkuruca.presentation.theme.RecipeAppComposeTheme
import com.kadirkuruca.presentation.theme.cardBackgroundColor

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    categoryDto: Category,
    onCategoryClick: (Category) -> Unit
) {
    ElevatedCard(
        modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onCategoryClick.invoke(categoryDto)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = RecipeAppColors.cardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        AsyncImage(
            model = categoryDto.strCategoryThumb,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
        )
        Text(
            text = categoryDto.strCategory,
            style = AppTypography.h5,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryCardPreview() {
    RecipeAppComposeTheme {
        CategoryCard(categoryDto = Category.getTestCategories().first()) {

        }
    }
}