package com.ruslangrigoriev.poloskun_app.data.repository

import com.ruslangrigoriev.poloskun_app.data.MockProductsSource
import com.ruslangrigoriev.poloskun_app.data.source.RemoteDataSource
import com.ruslangrigoriev.poloskun_app.domain.Product
import com.ruslangrigoriev.poloskun_app.domain.Resource
import com.ruslangrigoriev.poloskun_app.utils.getResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class ProductsRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getAllProducts(): List<Product> {
        delay(2000)
       return MockProductsSource.getAllProducts()
        //return getResponse { remoteDataSource.getAllProducts() }
    }


}