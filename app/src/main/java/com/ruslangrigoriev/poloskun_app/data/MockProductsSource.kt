package com.ruslangrigoriev.poloskun_app.data

import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.domain.Product

object MockProductsSource {

private val imageMap = mapOf(
    "1132П" to R.drawable.gel_universal,
    "1140П" to R.drawable.gel_concentrat,
    "1131П" to R.drawable.gel_beloe,
    "1134П" to R.drawable.gel_chernoe,
    "1153П" to R.drawable.gel_cvetnoe,
    "1168П" to R.drawable.gel_detskoe,

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
                name = "Гель концентрат для стирки",
                quantity = 20,
                purchaseCost = 213.75,
                retailPrice = 430.0,
                isBottling = true,
                image = imageMap["1140П"]!!

            ),
            Product(
                id = 3,
                article = "1131П",
                name = "Гель для стирки белого белья",
                quantity = 20,
                purchaseCost = 169.65,
                retailPrice = 350.0,
                isBottling = true,
                image = imageMap["1132П"]!!
            ),
            Product(
                id = 4,
                article = "1134П",
                name = "Гель для стирки черного белья",
                quantity = 20,
                purchaseCost = 171.9,
                retailPrice = 350.0,
                isBottling = true,
                image = imageMap["1134П"]!!
            ),
            Product(
                id = 5,
                article = "1153П",
                name = "Гель для стирки цветного белья",
                quantity = 20,
                purchaseCost = 173.7,
                retailPrice = 370.0,
                isBottling = true,
                image = imageMap["1153П"]!!
            ),
            Product(
                id = 5,
                article = "1168П",
                name = "Гель для стирки детских вещей",
                quantity = 20,
                purchaseCost = 166.2,
                retailPrice = 430.0,
                isBottling = true,
                image = imageMap["1168П"]!!
            )
        )
    }
}