package com.marianunez.pokedexcompose.data.network

import com.marianunez.pokedexcompose.data.network.response.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRestService {

    @GET(ApiConstants.POKEMON_LIST)
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 20,
    ): List<PokemonResult>
}