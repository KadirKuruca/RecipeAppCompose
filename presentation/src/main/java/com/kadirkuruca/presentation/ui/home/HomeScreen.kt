package com.kadirkuruca.presentation.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kadirkuruca.data.model.remote.filteredmeal.FilteredMeal
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.component.CustomSearchBar
import com.kadirkuruca.presentation.theme.AppTypography
import com.kadirkuruca.presentation.theme.RecipeAppColors
import com.kadirkuruca.presentation.theme.RecipeAppComposeTheme
import com.kadirkuruca.presentation.theme.backgroundColor
import com.kadirkuruca.presentation.theme.navigationBackIconColor
import com.kadirkuruca.presentation.widget.AppToolbar
import com.kadirkuruca.presentation.widget.MealCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    HomeScreenBody(
        modifier
    ) {
        HomeScreenContent(it)
    }
}
@Composable
fun HomeScreenContent(
    innerPadding: PaddingValues
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = RecipeAppColors.backgroundColor),
    ) {
        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        CustomSearchBar(
            query = text,
            onQueryChange = { text = it},
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier.padding(24.dp),
            leadingIcon = {
                Icon(imageVector = Icons.TwoTone.Search, contentDescription = null, tint = RecipeAppColors.navigationBackIconColor)
            },
            placeHolder = {
                Text(text = "Search", style = AppTypography.body1)
            }
        )

        Text(
            text = "Today's Suggestion",
            style = AppTypography.h2,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        val list = FilteredMeal.getTestFilteredMealList()
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 24.dp)
        ) {
            items(list) {
                MealCard(mealDto = it) { meal ->
                    Toast.makeText(context, meal.strMeal, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(titleResId = R.string.menu_home)
        },
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    RecipeAppComposeTheme {
        HomeScreenBody {
            HomeScreenContent(it)
        }
    }
}