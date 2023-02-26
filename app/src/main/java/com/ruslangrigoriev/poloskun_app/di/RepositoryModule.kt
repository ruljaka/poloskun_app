package com.ruslangrigoriev.poloskun_app.di

import com.ruslangrigoriev.poloskun_app.data.repository.ProductsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductsRepository(get()) }
}