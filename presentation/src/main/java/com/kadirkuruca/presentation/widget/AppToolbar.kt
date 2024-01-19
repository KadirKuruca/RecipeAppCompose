package com.kadirkuruca.presentation.widget

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kadirkuruca.presentation.theme.AppTypography
import com.kadirkuruca.presentation.theme.RecipeAppColors
import com.kadirkuruca.presentation.theme.navigationBackIconColor

@Composable
fun AppToolbar(
    @StringRes titleResId: Int,
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = titleResId),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = AppTypography.h2,
                color = Color.White
            )
        },
        backgroundColor = RecipeAppColors.primary,
        modifier = Modifier.fillMaxWidth(),
        elevation = elevation
    )
}

@Composable
fun AppToolbarWithNavIcon(
    @StringRes titleResId: Int,
    pressOnBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                stringResource(titleResId),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = AppTypography.h2
            )
        },
        navigationIcon = {
            Icon(
                rememberVectorPainter(Icons.Filled.ArrowBack),
                contentDescription = null,
                tint = RecipeAppColors.navigationBackIconColor,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { pressOnBack.invoke() }
            )
        },
        backgroundColor = RecipeAppColors.primary,
        modifier = Modifier.fillMaxWidth()
    )
}