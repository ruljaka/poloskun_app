package com.ruslangrigoriev.poloskun_app.di

import com.ruslangrigoriev.poloskun_app.ui.navigation.Navigator
import org.koin.dsl.module

val navigatorModule = module {
    single { Navigator() }
}