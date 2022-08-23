package com.marianunez.pokedexcompose.fakedata

import com.marianunez.pokedexcompose.data.network.response.PokemonList
import com.marianunez.pokedexcompose.data.network.response.PokemonResult


val fakePokemonListResponse = PokemonList(
    count = 1154,
    next = "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
    results = listOf(
        PokemonResult(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        ),
        PokemonResult(
            name = "ivysaur",
            url = "https://pokeapi.co/api/v2/pokemon/2/"
        ),
        PokemonResult(
            name = "venusaur",
            url = "https://pokeapi.co/api/v2/pokemon/3/"
        ),
        PokemonResult(
            name = "charmander",
            url = "https://pokeapi.co/api/v2/pokemon/4/"
        )
    )
)

val fakePokemonResultResponse = PokemonResult(
    name = "bulbasaur",
    url = "https://pokeapi.co/api/v2/pokemon/1/"
)