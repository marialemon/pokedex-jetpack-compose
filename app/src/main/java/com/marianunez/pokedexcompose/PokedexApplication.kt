package com.marianunez.pokedexcompose

import android.app.Application
import com.marianunez.pokedexcompose.di.pokedexModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            loadKoinModules(pokedexModule)
        }
    }
}