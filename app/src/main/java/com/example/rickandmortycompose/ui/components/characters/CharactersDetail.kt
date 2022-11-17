package com.example.rickandmortycompose.ui.components.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.model.Location
import com.example.rickandmortycompose.model.Origin
import com.example.rickandmortycompose.model.SingleCharacter
import com.example.rickandmortycompose.ui.components.H2Text
import com.example.rickandmortycompose.ui.components.NormalText
import com.example.rickandmortycompose.ui.components.Subtitle1Text
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetail(
    modifier: Modifier = Modifier,
    person: SingleCharacter,
    onClickFavorite: (person: SingleCharacter) -> Unit = {}
) {
    val isPersonFavorite = rememberSaveable {
        mutableStateOf(person.isFavorite)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier.size(200.dp),
                elevation = 6.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                GlideImage(
                    imageModel = person.image,
                    contentScale = ContentScale.Fit,
                    placeHolder = ImageBitmap.imageResource(R.drawable.ic_foto),
                    error = ImageBitmap.imageResource(R.drawable.ic_foto),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = stringResource(id = R.string.person_photo_text),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    H2Text(
                        text = person.name
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (person.status == "Alive") {
                        Image(
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 8.dp),
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
                    NormalText(text = "${person.status} - ${person.species}")
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconToggleButton(
                        checked = isPersonFavorite.value,
                        onCheckedChange = {
                            isPersonFavorite.value = it
                            onClickFavorite(person)
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            imageVector = if (isPersonFavorite.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                            contentDescription = stringResource(R.string.person_add_to_favorite_cd),
                            tint = if (isPersonFavorite.value) Color.Red else Color.White
                        )
                    }
                }
            }

        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                ) {
                    Subtitle1Text(
                        text = stringResource(id = R.string.person_last_known_location_text),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    NormalText(
                        modifier = Modifier.padding(top = 4.dp),
                        text = person.location.name
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                ) {
                    Subtitle1Text(
                        text = stringResource(id = R.string.person_first_seen_in_text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                    )
                    NormalText(
                        modifier = Modifier.padding(top = 4.dp),
                        text = person.episode.lastOrNull().toString()
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                ) {
                    Subtitle1Text(
                        text = stringResource(id = R.string.person_list_of_episodes_text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                    )
                    NormalText(
                        modifier = Modifier.padding(top = 4.dp),
                        text = person.episode.firstOrNull().toString()
                    )
                }
            }
        }
    }
}


@Preview()
@Composable
fun previewDetails() {
    val person = SingleCharacter(
        id = 2,
        name = "Morty Smith",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = Origin(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = Location(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/20"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
    )
    CharacterDetail(person = person)
}