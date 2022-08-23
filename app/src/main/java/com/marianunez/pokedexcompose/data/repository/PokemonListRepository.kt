package com.marianunez.pokedexcompose.data.repository

import com.marianunez.pokedexcompose.data.network.response.PokemonList

interface PokemonListRepository {

    suspend fun getPokemonList(): Result<PokemonList>
}