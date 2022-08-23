package com.marianunez.pokedexcompose.data.datasource.cloud

import com.marianunez.pokedexcompose.data.network.ApiConstants
import com.marianunez.pokedexcompose.data.network.ApiFactoryService
import com.marianunez.pokedexcompose.data.network.ApiRestService
import com.marianunez.pokedexcompose.data.network.response.PokemonList
import retrofit2.HttpException

class PokemonListCloudDataSource(private val apiFactoryService: ApiFactoryService) {

    suspend fun getPokemonList(): Result<PokemonList> =
        try {
            val api = apiFactoryService.createApi(ApiRestService::class.java, ApiConstants.BASE_URL)
            Result.success(api.getPokemonList(20, 20))
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        } catch (e: IllegalArgumentException) {
            Result.failure(e)
        }
}