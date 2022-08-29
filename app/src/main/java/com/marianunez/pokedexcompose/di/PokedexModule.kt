package com.marianunez.pokedexcompose.di

import com.marianunez.pokedexcompose.data.datasource.cloud.PokemonListCloudDataSource
import com.marianunez.pokedexcompose.data.network.ApiFactoryService
import com.marianunez.pokedexcompose.data.repository.PokemonListRepository
import com.marianunez.pokedexcompose.data.repository.PokemonListRepositoryImpl
import com.marianunez.pokedexcompose.domain.PokemonListUseCase
import com.marianunez.pokedexcompose.ui.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokedexModule = module {

    single { ApiFactoryService() }
    single { PokemonListCloudDataSource(get()) }
    single<PokemonListRepository> { PokemonListRepositoryImpl(get()) }
    single { PokemonListUseCase(get()) }

    viewModel { PokemonListViewModel(get()) }
}