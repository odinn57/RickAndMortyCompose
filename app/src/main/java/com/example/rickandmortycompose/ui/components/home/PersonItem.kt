package com.example.rickandmortycompose.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.model.SingleCharacter
import com.example.rickandmortycompose.ui.components.H2Text
import com.example.rickandmortycompose.ui.components.NormalText
import com.example.rickandmortycompose.ui.components.Subtitle1Text
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme


@Composable
fun PersonItem(person: SingleCharacter, modifier: Modifier = Modifier) {
    val personState by remember { mutableStateOf(person) }
    val isPersonFavorite = remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(6.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 5.dp,
        backgroundColor = CardBackground
    ) {
        Box() {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_foto),
                    contentDescription = stringResource(id = R.string.person_photo_text),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(160.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {
                    H2Text(
                        text = personState.name,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (personState.status == "Alive") {
                            Image(
                                modifier = Modifier.size(12.dp),
                                painter = painterResource(id = R.drawable.ic_circle_green),
                                contentDescription = stringResource(
                                    id = R.string.person_status_text
                                )
                            )
                        } else {
                            Image(
                                modifier = Modifier.size(12.dp),
                                painter = painterResource(id = R.drawable.ic_circle_red),
                                contentDescription = stringResource(
                                    id = R.string.person_status_text
                                )
                            )
                        }
                        NormalText(text = "${personState.status} - ${personState.species}")
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Subtitle1Text(
                            text = stringResource(id = R.string.person_last_known_location_text),
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = personState.location.name)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        contentAlignment = Alignment.BottomEnd

                    ) {
                        IconToggleButton(checked = isPersonFavorite.value,
                            onCheckedChange = {
                                isPersonFavorite.value = it
                            }) {
                            Icon(
                                imageVector = if (isPersonFavorite.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                                contentDescription = stringResource(R.string.person_add_to_favorite_cd),
                                tint = if (isPersonFavorite.value) Color.Red else Color.White
                            )
                        }
                    }
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PersonItemPreview(person: SingleCharacter = SingleCharacter(name = "Adam Smith")) {
    RickAndMortyComposeTheme {
        Surface() {
            PersonItem(SingleCharacter(name = "Adam Smith"))
        }
    }
}