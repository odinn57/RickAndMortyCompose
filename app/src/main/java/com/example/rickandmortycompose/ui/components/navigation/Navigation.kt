package com.example.rickandmortycompose.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortycompose.model.SingleCharacter
import com.example.rickandmortycompose.screens.characters.CharacterDetailScreen
import com.example.rickandmortycompose.screens.characters.CharactersScreen
import com.example.rickandmortycompose.screens.home.HomeScreen
import com.example.rickandmortycompose.screens.splash.SplashScreen
import com.example.rickandmortycompose.ui.components.NavigationKeys

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        composable(route = SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }
        composable(route = HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(route = CHARACTERS_SCREEN) {
            CharactersScreen(navController = navController)
        }
        composable(route = CHARACTER_DETAIL_SCREEN) {
            navController.getArgument<SingleCharacter>(NavigationKeys.CHARACTER_DETAIL_KEY).let {
                CharacterDetailScreen(navController = navController, person = it)
            }

        }
    }
}
