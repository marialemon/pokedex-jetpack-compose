package com.marianunez.pokedexcompose.data.network.response

data class PokemonList(
    val count: Int = 0,
    val next: String = "",
    val previous: String = "",
    val results: List<PokemonResult> = emptyList()
)

data class PokemonResult(
    val id: String,
    val name: String = "",
    val url: String = ""
)