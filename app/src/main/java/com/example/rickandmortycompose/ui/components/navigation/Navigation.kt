package com.example.rickandmortycompose.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortycompose.screens.home.HomeScreen
import com.example.rickandmortycompose.screens.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        composable(route = SPLASH_SCREEN) {
            SplashScreen(navController)
        }
        composable(route = HOME_SCREEN) {
            HomeScreen(navController)
        }
    }
}
