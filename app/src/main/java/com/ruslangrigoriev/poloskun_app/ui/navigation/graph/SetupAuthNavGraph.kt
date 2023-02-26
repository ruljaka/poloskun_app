package com.ruslangrigoriev.poloskun_app.ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.screen.auth.forgot.ForgotScreen
import com.ruslangrigoriev.poloskun_app.ui.screen.auth.login.LoginScreen
import com.ruslangrigoriev.poloskun_app.ui.screen.auth.signUp.SignUpScreen
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.setupAuthNavGraph() {
    navigation(
        route = Graph.AuthGraph.destination,
        startDestination = Screen.Login.destination
    ) {
        composable(route = Screen.Login.destination) {
            LoginScreen(getViewModel())
        }
        composable(route = Screen.SignUp.destination) {
            SignUpScreen()
        }
        composable(route = Screen.Forgot.destination) {
            ForgotScreen()
        }
    }
}

