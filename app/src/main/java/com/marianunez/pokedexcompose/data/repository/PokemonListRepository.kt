package com.marianunez.pokedexcompose.data.repository

import com.marianunez.pokedexcompose.data.network.response.PokemonResult

interface PokemonListRepository {

    suspend fun getPokemonList(): Result<List<PokemonResult>>
}