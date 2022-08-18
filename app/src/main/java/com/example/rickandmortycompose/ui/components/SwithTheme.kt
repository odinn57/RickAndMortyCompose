package com.example.rickandmortycompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.data.datastore.StoreTheme
import com.example.rickandmortycompose.ui.theme.Theme
import com.example.rickandmortycompose.ui.theme.White
import com.example.rickandmortycompose.ui.theme.isAppDarkTheme
import kotlinx.coroutines.launch

@Composable
fun SwitchThemeItem(modifier: Modifier = Modifier) {
    val dataStore = StoreTheme(LocalContext.current)
    val scope = rememberCoroutineScope()
    val theme = remember { mutableStateOf(Theme.Light.name) }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.change_app_theme),
            fontSize = 16.sp,
            color = White
        )
        Switch(checked = isAppDarkTheme(),
            onCheckedChange = {
                if (theme.value == Theme.Light.name) {
                    scope.launch {
                        dataStore.saveTheme(Theme.Dark.name)
                    }
                    theme.value = Theme.Dark.name
                } else {
                    scope.launch {
                        dataStore.saveTheme(Theme.Light.name)
                    }
                    theme.value = Theme.Light.name
                }
            })

    }
}