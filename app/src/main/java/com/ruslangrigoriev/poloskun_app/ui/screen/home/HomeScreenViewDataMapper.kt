package com.ruslangrigoriev.poloskun_app.ui.screen.home

import com.ruslangrigoriev.poloskun_app.domain.Product
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenItem.HomeScreenProductItem

class MainScreenViewDataMapper {

    fun map(products: List<Product>): List<HomeScreenProductItem> {
        val viewData = mutableListOf<HomeScreenProductItem>()
        viewData.addAll(products.map { product ->
            HomeScreenProductItem(
                id = product.id,
                article = product.article,
                name = product.name,
                quantity = product.quantity,
                purchaseCost = product.purchaseCost,
                retailPrice = product.retailPrice,
                isBottling = product.isBottling,
                image = product.image,
                isChecked = false
            )
        })
        return viewData
    }
}