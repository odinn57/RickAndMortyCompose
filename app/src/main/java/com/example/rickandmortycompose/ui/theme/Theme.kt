package com.example.rickandmortycompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.rickandmortycompose.data.datastore.StoreTheme

private val DarkColorPalette = darkColors(
    primary = CardBackground,
    primaryVariant = MainBackground,
    secondary = White,
    background = Black,
    surface = CardBackground
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = CardBackground,
    surface = CardBackground

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun RickAndMortyComposeTheme(
    darkTheme: Boolean = isAppDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun isAppDarkTheme(): Boolean {
    val dataStore = StoreTheme(LocalContext.current)
    val theme by dataStore.getTheme.collectAsState("")
    return when (theme) {
        Theme.Light.name -> false
        Theme.Dark.name -> true
        else -> isSystemInDarkTheme()

    }
}

enum class Theme {
    Light,
    Dark
}
