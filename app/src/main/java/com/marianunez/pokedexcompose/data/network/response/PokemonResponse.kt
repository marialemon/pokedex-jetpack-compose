package com.marianunez.pokedexcompose.data.network.response

data class PokemonList(
    val count: Int = 0,
    val next: String = "",
    val results: List<PokemonResult> = emptyList()
)

data class PokemonResult(
    val name: String = "",
    val url: String = ""
)