package com.ruslangrigoriev.poloskun_app.ui.screen.home

import com.ruslangrigoriev.poloskun_app.data.base.Reducer
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenEvent.*

class HomeScreenReducer(
    initial: HomeScreenState,
    private val navigator: Navigator,
) : Reducer<HomeScreenState, HomeScreenEvent>(initial) {

    override fun reduce(oldState: HomeScreenState, event: HomeScreenEvent) {
        when (event) {
            is ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.items))
            }
            is OnItemCheckedChanged -> {
                val newList = oldState.data.toMutableList()
                newList[event.index] =
                    (newList[event.index] as HomeScreenItem.HomeScreenProductItem).copy(isChecked = event.isChecked)
                setState(oldState.copy(data = newList))
            }
            is ShowError -> {
                setState(oldState.copy(isLoading = false, errorMessage = event.message))
            }
            is OpenDetailsScreen -> {
                navigator.navigateTo(Screen.Details.destination + "/${event.productId}", null)
            }
        }
    }
}