package com.example.rickandmortycompose.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortycompose.ui.components.home.CatalogMenu
import com.example.rickandmortycompose.ui.components.home.DrawerMenu
import com.example.rickandmortycompose.ui.components.home.TopAppBarMenu
import com.example.rickandmortycompose.ui.components.navigation.CHARACTERS_SCREEN
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    RickAndMortyComposeTheme {
        Surface {
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBarMenu(onOpenMenu = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    })
                },
                drawerContent = {
                    DrawerMenu(
                        onAboutAppClick = {},
                        onPersonsClick = { navController.navigate(CHARACTERS_SCREEN) },
                        onLocationsClick = {},
                        onEpisodesClick = {}
                    )
                },
                drawerBackgroundColor = CardBackground.copy(alpha = 0.8f)

            ) { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    CatalogMenu(
                        onPersonsPressed = { navController.navigate(CHARACTERS_SCREEN) },
                        onEpisodesPressed = {},
                        onLocationsPressed = {}
                    )
                }

            }
        }

    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}