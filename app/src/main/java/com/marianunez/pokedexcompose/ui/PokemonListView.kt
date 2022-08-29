package com.marianunez.pokedexcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.marianunez.pokedexcompose.data.network.response.PokemonResult

@Composable
fun PokemonListView(
    navController: NavController, pokemonList: List<PokemonResult>
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
            Text(text = "Pokédex", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                hint = "Search..."
            ) {
            }
            PokemonList(navController = navController, pokemonList = pokemonList)
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused.not()
                },
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun PokemonList(
    navController: NavController,
    pokemonList: List<PokemonResult>
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(pokemonList) {
            PokemonCard(
                pokemon = pokemonList[0],
                navController = navController
            )
        }
    }
}

@Composable
fun PokemonCard(
    pokemon: PokemonResult,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Card(shape = RoundedCornerShape(10.dp), modifier = modifier
        .background(Color.Cyan)
        .clickable { navController.navigate("pokemonDetail/${pokemon.name}") }) {
        Column() {
            Text(text = pokemon.name)
            Text(text = pokemon.url)

        }
    }
}