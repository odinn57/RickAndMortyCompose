package com.example.rickandmortycompose.ui.components.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.rickandmortycompose.model.SingleCharacter

@Composable
fun CharactersList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<SingleCharacter>,
    onFavoriteClick: (person: SingleCharacter) -> Unit = {},
    onCardClick: (person: SingleCharacter) -> Unit = {}
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(list) { character ->
            character?.let {
                CharacterItem(
                    modifier = Modifier.clickable { onCardClick(character) },
                    person = character,
                    onClickFavorite = { onFavoriteClick(character) }
                )
            }
        }
    }
}