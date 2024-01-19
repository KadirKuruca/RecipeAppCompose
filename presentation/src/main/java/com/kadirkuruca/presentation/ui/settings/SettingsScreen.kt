package com.kadirkuruca.presentation.ui.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.widget.AppToolbar

@Composable
fun SettingsScreen(
   modifier: Modifier = Modifier
) {
    SettingsScreenBody(
        modifier
    ) {
        SettingsScreenContent()
    }
}

@Composable
fun SettingsScreenContent() {

}

@Composable
fun SettingsScreenBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(titleResId = R.string.menu_settings)
        },
        content = { pageContent.invoke(it) }
    )
}