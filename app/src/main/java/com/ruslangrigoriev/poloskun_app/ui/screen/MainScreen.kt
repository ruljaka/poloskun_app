package com.ruslangrigoriev.poloskun_app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.navigation.graph.SetupMainNavGraph
import com.ruslangrigoriev.poloskun_app.ui.widget.BottomBar
import com.ruslangrigoriev.poloskun_app.ui.widget.TopBar
import com.ruslangrigoriev.poloskun_app.utils.getTitleByRoute
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MainScreen(navigator: Navigator) {

    val navController = rememberNavController()
    val title = remember { mutableStateOf("") }

    LaunchedEffect("main_navigation") {
        navigator.sharedFlow
            .onEach {
                navController.navigate(it.first, it.second)
                //title.value = getTitleByRoute(it.first)
            }.launchIn(this)
        navController.currentBackStackEntryFlow
            .onEach { backStackEntry ->
                backStackEntry.destination.route?.let { title.value = getTitleByRoute(it) }
            }.launchIn(this)
    }

    Scaffold(
        topBar = { TopBar(title.value) },
        bottomBar = { BottomBar(navController, navigator) },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupMainNavGraph(navController = navController)
        }
    }
}