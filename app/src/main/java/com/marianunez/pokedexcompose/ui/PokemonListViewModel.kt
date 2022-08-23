package com.marianunez.pokedexcompose.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marianunez.pokedexcompose.data.network.response.PokemonList
import com.marianunez.pokedexcompose.domain.PokemonListUseCase
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonListUseCase: PokemonListUseCase): ViewModel() {

    private val _pokemonListResult = MutableLiveData<Result<PokemonList>>()
    val pokemonListResult: LiveData<Result<PokemonList>> = _pokemonListResult

    fun getPokemonList(){
        viewModelScope.launch {
            pokemonListUseCase.getPokemonList()
                .onSuccess { _pokemonListResult.postValue(Result.success(it)) }
                .onFailure { _pokemonListResult.postValue(Result.failure(Throwable())) }
        }
    }

}