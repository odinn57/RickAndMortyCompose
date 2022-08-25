package com.example.rickandmortycompose.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.example.rickandmortycompose.ui.theme.White

@Composable
fun TopAppBarMenu(
    title: String = stringResource(id = R.string.app_name),
    onOpenMenu: () -> Unit = {}
) {
    val expandedInfo = remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color.Black,
        navigationIcon = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { onOpenMenu() }) {
                    if (title != stringResource(id = R.string.app_name))
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(
                                id = R.string.back_text
                            ),
                            tint = White,
                            modifier = Modifier.size(24.dp)
                        )
                    else
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = stringResource(
                                id = R.string.menu_text
                            ),
                            tint = White,
                            modifier = Modifier.size(24.dp)
                        )
                }
            }
        },
        actions = {

            Box(modifier = Modifier) {
                IconButton(
                    onClick = { expandedInfo.value = true },
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = stringResource(id = R.string.about_app),
                        tint = White
                    )
                    DropdownMenu(
                        expanded = expandedInfo.value,
                        onDismissRequest = { expandedInfo.value = false },
                        modifier = Modifier.clickable(onClick = {
                            expandedInfo.value = false
                        })
                    ) {
                        Text(
                            stringResource(id = R.string.about_app),
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            stringResource(id = R.string.about_app_long),
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun PreviewTopAppBar() {
    RickAndMortyComposeTheme {
        TopAppBarMenu()
    }
}