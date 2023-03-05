package com.ruslangrigoriev.poloskun_app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.navigation.graph.SetupMainNavGraph
import com.ruslangrigoriev.poloskun_app.ui.widget.BottomBar
import com.ruslangrigoriev.poloskun_app.ui.widget.TopBar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MainScreen(navigator: Navigator) {

    val navController = rememberNavController()
    val title = remember { mutableStateOf("") }
    val rootScreens = listOf(
        Screen.Home.title,
        Screen.Settings.title,
        Screen.Cart.title
    )
    val isRootScreen = remember { mutableStateOf(false) }

    LaunchedEffect("main_navigation") {
        navigator.sharedFlow
            .onEach {
                navController.navigate(it.first, it.second)
            }.launchIn(this)
        navController.currentBackStackEntryFlow
            .onEach { backStackEntry ->
                backStackEntry.destination.route?.let {
                    title.value = getTitleByRoute(it)
                    isRootScreen.value = rootScreens.contains(title.value)
                }
            }.launchIn(this)
    }

    Scaffold(
        topBar = {
            if (isRootScreen.value) {
                TopBar(
                    title = title.value,
                    isRootScreen = isRootScreen.value,
                    popOnClick = { navController.popBackStack() })
            }
        },
        bottomBar = { BottomBar(navController, navigator) },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupMainNavGraph(navController = navController)
        }
    }
}

fun getTitleByRoute(route: String): String {
    return when {
        route.contains(Screen.Login.destination) -> Screen.Login.title
        route.contains(Screen.SignUp.destination) -> Screen.SignUp.title
        route.contains(Screen.Forgot.destination) -> Screen.Forgot.title
        route.contains(Screen.Home.destination) -> Screen.Home.title
        route.contains(Screen.Details.destination) -> Screen.Details.title
        route.contains(Screen.Settings.destination) -> Screen.Settings.title
        route.contains(Screen.Cart.destination) -> Screen.Cart.title
        else -> ("Route not found")
    }
}
