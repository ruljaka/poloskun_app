package com.ruslangrigoriev.poloskun_app.ui.screen.home

sealed class HomeScreenItem {
    object HomeScreenAddButtonItem : HomeScreenItem()
    data class HomeScreenProductItem(
        val id: Int,
        var article: String,
        val name: String,
        val quantity: Int,
        val purchaseCost: Double,
        val retailPrice: Double,
        val isBottling: Boolean,
        val image: Int,
        val isChecked: Boolean
    ) : HomeScreenItem()
}