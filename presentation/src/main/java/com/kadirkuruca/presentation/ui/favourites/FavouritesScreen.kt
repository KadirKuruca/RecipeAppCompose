package com.kadirkuruca.presentation.ui.favourites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.widget.AppToolbar

@Composable
fun FavouritesScreen(
    modifier: Modifier = Modifier
) {
    FavouritesScreenBody(
        modifier
    ) {
        FavouritesScreenContent()
    }
}

@Composable
fun FavouritesScreenContent() {

}

@Composable
fun FavouritesScreenBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(titleResId = R.string.menu_favourites)
        },
        content = { pageContent.invoke(it) }
    )
}