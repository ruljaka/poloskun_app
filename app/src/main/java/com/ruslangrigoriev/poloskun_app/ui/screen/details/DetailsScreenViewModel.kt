package com.ruslangrigoriev.poloskun_app.ui.screen.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenState
import com.ruslangrigoriev.poloskun_app.utils.PARAM_PRODUCT_ID

class DetailsScreenViewModel(
    private val navigator: Navigator,
    //private val getProductsListUseCase: GetProductsListUseCase,
    private val savedState: SavedStateHandle
) : ViewModel() {

//    fun toDetails() {
//        navigator.navigateTo(Screen.Details, null)
//    }

//    private val _state = mutableStateOf(HomeScreenState())
//    val state: State<HomeScreenState> = _state

    init {
//        savedState.get<String>(PARAM_PRODUCT_ID)?.let { productId ->
//            getDetails(productId)
//        }
    }

    private fun getDetails(productId: String) {}

}