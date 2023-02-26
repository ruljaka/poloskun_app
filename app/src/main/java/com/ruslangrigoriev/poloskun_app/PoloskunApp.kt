package com.ruslangrigoriev.poloskun_app

import android.app.Application
import com.ruslangrigoriev.poloskun_app.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PoloskunApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PoloskunApp)
            modules(modules)
        }
    }
}