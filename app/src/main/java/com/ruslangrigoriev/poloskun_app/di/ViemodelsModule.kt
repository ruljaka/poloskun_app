package com.ruslangrigoriev.poloskun_app.di

import com.ruslangrigoriev.poloskun_app.ui.screen.auth.login.LoginScreenViewModel
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vieModelsModule = module {
    viewModel { LoginScreenViewModel(get()) }
    viewModel { HomeScreenViewModel(get(), get(), get()) }
}
