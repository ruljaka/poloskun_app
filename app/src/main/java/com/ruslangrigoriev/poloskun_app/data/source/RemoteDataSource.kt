package com.ruslangrigoriev.poloskun_app.data.source

import com.ruslangrigoriev.poloskun_app.data.api.ProductApi

class RemoteDataSource(
    private val apiService: ProductApi
) {
    suspend fun getAllProducts() = apiService.getAllProducts()
}