package com.kadirkuruca.presentation.ui.categories

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kadirkuruca.data.model.remote.category.Category
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.widget.AppToolbar
import com.kadirkuruca.presentation.widget.CategoryCard

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier
) {
    CategoriesScreenBody(
        modifier
    ) {
        CategoriesScreenContent()
    }
}

@Composable
fun CategoriesScreenContent() {
    val context = LocalContext.current
    val list = Category.getTestCategories()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 12.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(list) {
            CategoryCard(categoryDto = it) { category ->
                Toast.makeText(context, category.strCategory, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun CategoriesScreenBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(titleResId = R.string.menu_categories)
        },
        content = { pageContent.invoke(it) }
    )
}