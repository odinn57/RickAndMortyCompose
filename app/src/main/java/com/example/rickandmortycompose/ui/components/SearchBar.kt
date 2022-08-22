package com.example.rickandmortycompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.Black
import com.example.rickandmortycompose.ui.theme.Whitish

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    val text = remember { mutableStateOf("") }
    TextField(
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        value = text.value,
        onValueChange = {
            text.value = it
        },
        leadingIcon = {
            Icon(Icons.Default.Search, null)
        },
        placeholder = {
            Text(stringResource(id = R.string.search_text))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Whitish,
            textColor = Black
        ),
        singleLine = true
    )
}

@Preview
@Composable
private fun PreviewSearchToolbar() {
    SearchBar()
}