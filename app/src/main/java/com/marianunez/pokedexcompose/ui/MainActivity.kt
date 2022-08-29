package com.marianunez.pokedexcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marianunez.pokedexcompose.ui.theme.PokedexComposeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: PokemonListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokedexComposeTheme {
                val navController = rememberNavController()
                val pokemonList by viewModel.pokemonListResult.observeAsState(emptyList())

                NavHost(navController = navController, startDestination = "pokemonList") {
                    composable("pokemonList") {
                        PokemonListView(navController = navController, pokemonList = pokemonList)
                    }
                    composable(route = "pokemonDetail/{pokemonName}", arguments = listOf(
                        navArgument("pokemonName") {
                            type = NavType.StringType
                        }
                    )) {
                        // TODO: poner la screen
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                    }
                }
            }
        }
    }
}