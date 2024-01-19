package com.kadirkuruca.presentation.ui.categories

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.widget.AppToolbar

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