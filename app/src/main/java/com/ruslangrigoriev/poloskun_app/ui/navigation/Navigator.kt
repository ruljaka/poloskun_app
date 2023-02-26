package com.ruslangrigoriev.poloskun_app.ui.navigation

import android.util.Log
import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigator {

    private val _sharedFlow =
        MutableSharedFlow<Pair<String, NavOptions?>>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(target: String, navOptions: NavOptions?) {
        _sharedFlow.tryEmit(Pair(target, navOptions))
    }

}