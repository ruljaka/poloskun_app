package com.ruslangrigoriev.poloskun_app.data.api

import com.ruslangrigoriev.poloskun_app.domain.Product
import retrofit2.http.GET

interface ProductApi {

    @GET ("products/get")
    suspend fun getAllProducts() : List<Product>
}