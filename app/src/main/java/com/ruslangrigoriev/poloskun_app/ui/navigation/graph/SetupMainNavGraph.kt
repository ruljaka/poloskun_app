package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph

@Composable
fun SetupMainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MainGraph.destination,
        startDestination = Graph.HomeGraph.destination
    ) {
        homeNavGraph()
        settingsNavGraph()
        cartNavGraph()
    }
}