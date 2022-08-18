package com.example.rickandmortycompose.ui.components.home

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.White

@Preview()
@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.empty_string,
    onClick: () -> Unit = {}
) {
    Text(
        text = stringResource(id = title),
        modifier = modifier
            .clickable { onClick() },
        fontSize = 16.sp,
        color = White
    )
}