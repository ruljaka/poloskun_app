package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.screen.SettingsScreen

fun NavGraphBuilder.settingsNavGraph() {
    navigation(
        route = Graph.SettingsGraph.destination,
        startDestination = Screen.Settings.destination
    ) {
        composable(route = Screen.Settings.destination) {
            SettingsScreen()
        }
    }
}