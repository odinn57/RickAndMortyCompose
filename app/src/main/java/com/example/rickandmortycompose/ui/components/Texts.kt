package com.example.rickandmortycompose.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortycompose.ui.theme.Typography

@Composable
fun H2Text(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.h2
    )
}

@Composable
fun Subtitle1Text(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.subtitle1
    )
}

@Composable
fun NormalText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.body1
    )
}