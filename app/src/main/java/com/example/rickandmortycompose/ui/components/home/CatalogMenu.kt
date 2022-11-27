package com.example.rickandmortycompose.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortycompose.R

@Preview(showBackground = true)
@Composable
fun CatalogMenu(
    modifier: Modifier = Modifier,
    onPersonsPressed: () -> Unit = {},
    onLocationsPressed: () -> Unit = {},
    onEpisodesPressed: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CatalogItem(
            imgRes = R.drawable.persons_catalog,
            titleRes = R.string.characters_catalog_menu,
            onCardClick = onPersonsPressed
        )
        CatalogItem(
            imgRes = R.drawable.locations_catalog,
            titleRes = R.string.locations_catalog_menu,
            onCardClick = onLocationsPressed
        )
        CatalogItem(
            imgRes = R.drawable.episodes_catalog,
            titleRes = R.string.episodes_catalog_menu,
            onCardClick = onEpisodesPressed
        )
    }
}