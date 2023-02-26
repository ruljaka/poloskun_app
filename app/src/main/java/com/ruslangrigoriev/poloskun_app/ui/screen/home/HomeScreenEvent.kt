package com.ruslangrigoriev.poloskun_app.ui.screen.home

import androidx.compose.runtime.Immutable
import com.ruslangrigoriev.poloskun_app.data.base.UiEvent

@Immutable
sealed class HomeScreenEvent : UiEvent {
    data class ShowData(val items: List<HomeScreenItem>) : HomeScreenEvent()
    data class ShowError(val message: String) : HomeScreenEvent()
    data class OnItemCheckedChanged(val index: Int, val isChecked: Boolean) : HomeScreenEvent()
    data class OpenDetailsScreen(val productId: Int) : HomeScreenEvent()
}

