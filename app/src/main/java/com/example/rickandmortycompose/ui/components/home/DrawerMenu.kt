package com.example.rickandmortycompose.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.components.H2Text
import com.example.rickandmortycompose.ui.components.Subtitle1Text
import com.example.rickandmortycompose.ui.theme.Black
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.White

@Composable
fun DrawerMenu(
    onAboutAppClick: () -> Unit = {},
    onPersonsClick: () -> Unit = {},
    onLocationsClick: () -> Unit = {},
    onEpisodesClick: () -> Unit = {},
) {
    Column {
        val menuModifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 56.dp)
                .background(Black),
        ) {
            Text(
                text = stringResource(
                    id = R.string.app_name
                ),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = White
            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    backgroundColor = CardBackground,
                    elevation = 8.dp,
                    modifier = menuModifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        DrawerItem(
                            title = R.string.about_app,
                            modifier = menuModifier,
                            onClick = { onAboutAppClick() }
                        )
                        Spacer(modifier = menuModifier.padding(vertical = 8.dp))
                    }
                }

                Card(
                    backgroundColor = CardBackground,
                    elevation = 8.dp,
                    modifier = menuModifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        H2Text(
                            text = stringResource(id = R.string.navigation_text),
                            modifier = menuModifier.padding(bottom = 4.dp)
                        )
                        DrawerItem(
                            title = R.string.characters_catalog_menu,
                            modifier = menuModifier,
                            onClick = { onPersonsClick() }
                        )
                        DrawerItem(
                            title = R.string.locations_catalog_menu,
                            modifier = menuModifier,
                            onClick = { onLocationsClick() }
                        )
                        DrawerItem(
                            title = R.string.episodes_catalog_menu,
                            modifier = menuModifier,
                            onClick = { onEpisodesClick() }
                        )
                        Spacer(modifier = menuModifier.padding(vertical = 8.dp))
                    }
                }

                Card(
                    backgroundColor = CardBackground,
                    elevation = 8.dp,
                    modifier = menuModifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Column() {
                        SwitchThemeItem(modifier = menuModifier)
                        Subtitle1Text(
                            text = stringResource(id = R.string.copyright_text),
                            modifier = menuModifier
                        )
                        Spacer(modifier = menuModifier.padding(vertical = 16.dp))
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun PreviewDrawerMenu() {
    DrawerMenu()
}
