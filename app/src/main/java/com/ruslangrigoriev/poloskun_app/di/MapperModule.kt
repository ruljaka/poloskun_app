package com.ruslangrigoriev.poloskun_app.di

import com.ruslangrigoriev.poloskun_app.ui.screen.home.MainScreenViewDataMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { MainScreenViewDataMapper() }
}