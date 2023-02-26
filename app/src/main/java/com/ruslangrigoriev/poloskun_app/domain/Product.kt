package com.ruslangrigoriev.poloskun_app.domain

import com.squareup.moshi.Json

data class Product(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "article")
    var article: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "quantity")
    val quantity: Int,
    @field:Json(name = "purchaseCost")
    val purchaseCost: Double,
    @field:Json(name = "retailPrice")
    val retailPrice: Double,
    @field:Json(name = "isBottling")
    val isBottling: Boolean,

    val image: Int
)
