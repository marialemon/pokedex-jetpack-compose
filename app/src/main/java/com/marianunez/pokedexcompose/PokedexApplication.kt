package com.marianunez.pokedexcompose

import android.app.Application
import com.marianunez.pokedexcompose.di.pokedexModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokedexApplication)
            modules(pokedexModule)
        }
    }
}