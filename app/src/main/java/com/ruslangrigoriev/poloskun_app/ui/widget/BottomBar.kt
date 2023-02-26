package com.ruslangrigoriev.poloskun_app.ui.widget

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200

@Composable
fun BottomBar(
    navController: NavHostController,
    navigator: Navigator
) {
    val screens = listOf(
        Screen.Home,
        Screen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = Teal200,
    ) {
        screens.forEach { screen ->
            addItem(
                screen,
                currentDestination,
                navigator,
                navController
            )
        }
    }
}

@Composable
fun RowScope.addItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navigator: Navigator,
    navController: NavHostController,
) {
    BottomNavigationItem(
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },
        label = { Text(text = screen.title) },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
        alwaysShowLabel = true,
        selected = currentDestination?.hierarchy?.any {
            it.parent?.route ==
                    when (screen) {
                        is Screen.Home -> Graph.HomeGraph.destination
                        else -> Graph.SettingsGraph.destination
                    }
        } == true,
        onClick = {
            navigator.navigateTo(
                screen.destination,
                NavOptions.Builder()
                    .setPopUpTo(
                        destinationId = navController.graph.findStartDestination().id,
                        inclusive = false,
                        saveState = true
                    )
                    .setRestoreState(true)
                    .setLaunchSingleTop(true)
                    .build()
            )
        }
    )
}
