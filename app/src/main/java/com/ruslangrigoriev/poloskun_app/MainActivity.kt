package com.ruslangrigoriev.poloskun_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.navigation.graph.SetupRootGraph
import com.ruslangrigoriev.poloskun_app.ui.theme.Poloskun_appTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {
    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Poloskun_appTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.White,
                        darkIcons = true
                    )
                }

                val navController = rememberNavController()
                val destinations =
                    listOf(
                        Screen.Login.destination,
                        Screen.SignUp.destination,
                        Screen.Forgot.destination,
                        Graph.MainGraph.destination
                    )

                LaunchedEffect(true) {
                    navigator.sharedFlow
                        .onEach {
                            if (destinations.contains(it.first)) {
                                navController.navigate(it.first, it.second)
                            }
                        }.launchIn(this)
                }

                SetupRootGraph(
                    navController = navController,
                    navigator = navigator
                )
            }
        }
    }
}


