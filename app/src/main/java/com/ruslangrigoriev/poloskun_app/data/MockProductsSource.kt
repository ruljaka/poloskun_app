package com.ruslangrigoriev.poloskun_app.data

import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.domain.Product

object MockProductsSource {

val imageMap = mapOf(
    "1132П" to R.drawable.gel_universal,
    "1140П" to R.drawable.crem_combi
)

    fun getAllProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                article = "1132П",
                name = "Гель для стирки универсальный",
                quantity = 20,
                purchaseCost = 155.25,
                retailPrice = 320.0,
                isBottling = true,
                image = imageMap["1132П"]!!
            ),
            Product(
                id = 2,
                article = "1140П",
                name = "Крем для защиты кожи комбинированного действия",
                quantity = 20,
                purchaseCost = 213.75,
                retailPrice = 430.0,
                isBottling = true,
                image = imageMap["1132П"]!!

            ),
            Product(
                id = 1,
                article = "1132П",
                name = "Гель для стирки универсальный",
                quantity = 20,
                purchaseCost = 155.25,
                retailPrice = 320.0,
                isBottling = true,
                image = imageMap["1132П"]!!
            ),
            Product(
                id = 2,
                article = "1140П",
                name = "Гель концентрат для стирки для стирки",
                quantity = 20,
                purchaseCost = 213.75,
                retailPrice = 430.0,
                isBottling = true,
                image = imageMap["1132П"]!!
            )
        )
    }
}