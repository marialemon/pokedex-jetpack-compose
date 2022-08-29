package com.marianunez.pokedexcompose.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marianunez.pokedexcompose.data.network.response.PokemonResult
import com.marianunez.pokedexcompose.domain.PokemonListUseCase
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonListUseCase: PokemonListUseCase) : ViewModel() {

    private val _pokemonListResult = MutableLiveData<List<PokemonResult>>()
    val pokemonListResult: LiveData<List<PokemonResult>> = _pokemonListResult

    fun getPokemonList() {
        viewModelScope.launch {
            pokemonListUseCase.getPokemonList()
                .onSuccess { pokemonList -> _pokemonListResult.postValue(pokemonList) }
                .onFailure { Throwable() }
        }
    }

}