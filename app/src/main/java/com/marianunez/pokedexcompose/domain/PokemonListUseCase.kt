package com.marianunez.pokedexcompose.domain

import com.marianunez.pokedexcompose.data.network.response.PokemonList
import com.marianunez.pokedexcompose.data.repository.PokemonListRepository

class PokemonListUseCase(private val pokemonListRepository: PokemonListRepository) {

    suspend fun getPokemonList(): Result<PokemonList> =
        pokemonListRepository.getPokemonList()
}