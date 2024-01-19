package com.kadirkuruca.presentation.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kadirkuruca.presentation.theme.RecipeAppColors
import com.kadirkuruca.presentation.theme.selectedBottomItemColor
import com.kadirkuruca.presentation.ui.navigation.BottomBarScreen
import com.kadirkuruca.presentation.ui.navigation.BottomNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) {
        Box(modifier = Modifier.padding(it)) {
            BottomNavGraph(navController = navController)
        }
    }
}
@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.HomeScreen,
        BottomBarScreen.CategoriesScreen,
        BottomBarScreen.FavouritesScreen,
        BottomBarScreen.SettingsScreen,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = RecipeAppColors.primary
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    BottomNavigationItem(
        label = null,
        icon = {
            Icon(
                painter = if (selected) painterResource(id = screen.selectedIcon) else painterResource(id = screen.icon),
                contentDescription = null
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        selectedContentColor = selectedBottomItemColor,
        unselectedContentColor = selectedBottomItemColor
    )
}