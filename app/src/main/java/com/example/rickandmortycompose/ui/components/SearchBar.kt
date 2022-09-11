package com.example.rickandmortycompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.Black
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.Whitish

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onClickFavorite: () -> Unit = {}
) {
    val text = remember { mutableStateOf("") }
    val isShowOnlyFavorite = remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .sizeIn(minHeight = 56.dp)
            .background(Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = modifier
                .heightIn(48.dp)
                .padding(4.dp)
                .weight(0.9f),
            value = text.value,
            onValueChange = {
                text.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Search, null)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_text),
                    color = CardBackground
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Whitish,
                textColor = Black
            ),
            singleLine = true,
            trailingIcon = {
                IconToggleButton(
                    modifier = Modifier
                        .weight(0.1f)
                        .padding(end = 4.dp),
                    checked = isShowOnlyFavorite.value,
                    onCheckedChange = {
                        isShowOnlyFavorite.value = it
                        onClickFavorite()
                    }) {
                    Icon(
                        imageVector = if (isShowOnlyFavorite.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                        contentDescription = stringResource(R.string.person_add_to_favorite_cd),
                        tint = if (isShowOnlyFavorite.value) Color.Red else Color.Gray
                    )
                }
            }
        )

    }
}

@Preview
@Composable
private fun PreviewSearchToolbar() {
    SearchBar()
}