package com.ruslangrigoriev.poloskun_app.ui.screen.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.ruslangrigoriev.poloskun_app.ui.navigation.Graph
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginScreenViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun login() {
        navigator.navigateTo(
            Graph.MainGraph.destination,
            NavOptions.Builder()
                .setPopUpTo(Screen.Login.destination, true)
                .build()
        )
    }
}