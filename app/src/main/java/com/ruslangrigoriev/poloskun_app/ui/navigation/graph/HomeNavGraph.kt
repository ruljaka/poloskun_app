package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.screen.details.DetailsScreen
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreen
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.homeNavGraph() {
    navigation(
        route = Graph.HomeGraph.destination,
        startDestination = Screen.Home.destination
    ) {
        composable(route = Screen.Home.destination) {
            HomeScreen(getViewModel())
        }
        composable(route = Screen.Details.destination + "/{productId}") {
            DetailsScreen()
        }
    }
}