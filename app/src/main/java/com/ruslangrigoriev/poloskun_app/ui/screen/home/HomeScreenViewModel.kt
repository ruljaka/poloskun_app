package com.ruslangrigoriev.poloskun_app.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.ruslangrigoriev.poloskun_app.data.base.BaseViewModel
import com.ruslangrigoriev.poloskun_app.data.repository.ProductsRepository
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenEvent.ShowData
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    navigator: Navigator,
    private val repository: ProductsRepository,
    private val mapper: MainScreenViewDataMapper
) : BaseViewModel<HomeScreenState, HomeScreenEvent>() {

    private val reducer = HomeScreenReducer(HomeScreenState.initial(), navigator)

    override val state: StateFlow<HomeScreenState>
        get() = reducer.state

    override fun obtainEvent(event: HomeScreenEvent) {
        reducer.sendEvent(event)
    }

    init {
        viewModelScope.launch {
            val data = repository.getAllProducts()
            reducer.sendEvent(ShowData(mapper.map(data)))

            // TODO show error
        }
    }

}