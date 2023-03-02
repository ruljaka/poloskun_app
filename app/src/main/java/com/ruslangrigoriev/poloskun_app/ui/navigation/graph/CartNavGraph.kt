package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.screen.cart.CartScreen

fun NavGraphBuilder.cartNavGraph() {
    navigation(
        route = Graph.CartGraph.destination,
        startDestination = Screen.Cart.destination
    ) {
        composable(route = Screen.Cart.destination) {
            CartScreen()
        }
    }
}