package com.kadirkuruca.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kadirkuruca.presentation.R
import com.kadirkuruca.presentation.ui.categories.CategoriesScreen
import com.kadirkuruca.presentation.ui.favourites.FavouritesScreen
import com.kadirkuruca.presentation.ui.home.HomeScreen
import com.kadirkuruca.presentation.ui.settings.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination =  BottomBarScreen.HomeScreen.route) {
        composable(route = BottomBarScreen.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.CategoriesScreen.route) {
            CategoriesScreen()
        }
        composable(route = BottomBarScreen.FavouritesScreen.route) {
            FavouritesScreen()
        }
        composable(route = BottomBarScreen.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}

sealed class BottomBarScreen(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
) {
    object HomeScreen : BottomBarScreen(
        "home",
        R.string.menu_home,
        R.drawable.ic_menu_home_outline,
        R.drawable.ic_menu_home
    )
    object CategoriesScreen: BottomBarScreen(
        "categories",
        R.string.menu_categories,
        R.drawable.ic_menu_categories_outline,
        R.drawable.ic_menu_category
    )
    object FavouritesScreen: BottomBarScreen(
        "favourites",
        R.string.menu_favourites,
        R.drawable.ic_menu_favourites_outline,
        R.drawable.ic_menu_favourites
    )
    object SettingsScreen: BottomBarScreen(
        "settings",
        R.string.menu_settings,
        R.drawable.ic_menu_setting_outline,
        R.drawable.ic_menu_settings
    )
}