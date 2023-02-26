package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.screen.MainScreen

@Composable
fun SetupRootGraph(
    navController: NavHostController,
    navigator: Navigator
) {
    NavHost(
        navController = navController,
        route = Graph.RootGraph.destination,
        startDestination = Graph.AuthGraph.destination
    ) {
        setupAuthNavGraph()
        composable(route = Graph.MainGraph.destination) {
            MainScreen(navigator)
        }
    }
}


