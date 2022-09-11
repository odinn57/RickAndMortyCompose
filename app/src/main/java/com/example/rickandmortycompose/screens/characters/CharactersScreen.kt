package com.example.rickandmortycompose.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortycompose.ui.components.NavigationKeys
import com.example.rickandmortycompose.ui.components.SearchBar
import com.example.rickandmortycompose.ui.components.characters.CharactersList
import com.example.rickandmortycompose.ui.components.navigation.CHARACTER_DETAIL_SCREEN
import com.example.rickandmortycompose.ui.components.navigation.navigate


@Composable
fun CharactersScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Surface {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                SearchBar()
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                val charactersData = charactersViewModel.charactersPager.collectAsLazyPagingItems()
                CharactersList(
                    list = charactersData,
                    onCardClick = {
                        navController.navigate(
                            CHARACTER_DETAIL_SCREEN,
                            NavigationKeys.CHARACTER_DETAIL_KEY to it
                        )
                    },
                    onFavoriteClick = {
                        if (it.isFavorite)
                            charactersViewModel.addFavorite(it)
                        else
                            charactersViewModel.deleteFavorite(it)

                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharactersScreen() {
    CharactersScreen(navController = rememberNavController())
}
