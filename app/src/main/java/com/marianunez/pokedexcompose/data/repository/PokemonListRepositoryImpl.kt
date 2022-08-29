package com.marianunez.pokedexcompose.data.repository

import com.marianunez.pokedexcompose.data.datasource.cloud.PokemonListCloudDataSource
import com.marianunez.pokedexcompose.data.network.response.PokemonResult
import org.koin.core.component.KoinComponent

class PokemonListRepositoryImpl(private val pokemonListCloudDataSource: PokemonListCloudDataSource): PokemonListRepository, KoinComponent {

    override suspend fun getPokemonList(): Result<List<PokemonResult>> =
        pokemonListCloudDataSource.getPokemonList()
}