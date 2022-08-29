package com.marianunez.pokedexcompose.domain

import com.marianunez.pokedexcompose.data.network.response.PokemonResult
import com.marianunez.pokedexcompose.data.repository.PokemonListRepository

class PokemonListUseCase(private val pokemonListRepository: PokemonListRepository) {

    suspend fun getPokemonList(): Result<List<PokemonResult>> =
        pokemonListRepository.getPokemonList()
}