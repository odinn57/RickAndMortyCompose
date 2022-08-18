package com.example.rickandmortycompose.ui.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.model.SingleCharacter

@Composable
fun PersonList(list: List<SingleCharacter> = emptyList()) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = list) { person ->
            PersonItem(person = person)
        }
    }
}