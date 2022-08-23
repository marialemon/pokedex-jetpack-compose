package com.marianunez.pokedexcompose.data.repository

import com.marianunez.pokedexcompose.data.datasource.cloud.PokemonListCloudDataSource
import com.marianunez.pokedexcompose.data.network.response.PokemonList

class PokemonListRepositoryImpl(private val pokemonListCloudDataSource: PokemonListCloudDataSource): PokemonListRepository {

    override suspend fun getPokemonList(): Result<PokemonList> =
        pokemonListCloudDataSource.getPokemonList()
}