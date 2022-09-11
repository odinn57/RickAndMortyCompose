package com.example.rickandmortycompose.ui.components.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
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
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun CharacterItem(
    person: SingleCharacter,
    modifier: Modifier = Modifier,
    onClickFavorite: (person: SingleCharacter) -> Unit = {}
) {
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
        Row() {
            GlideImage(
                imageModel = person.image,
                contentScale = ContentScale.Fit,
                error = ImageBitmap.imageResource(R.drawable.ic_foto),
                modifier = Modifier.size(160.dp),
                contentDescription = stringResource(id = R.string.person_photo_text),
                previewPlaceholder = R.drawable.ic_foto
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    H2Text(
                        modifier = Modifier.weight(0.8f),
                        text = personState.name
                    )
                    IconToggleButton(
                        checked = isPersonFavorite.value,
                        onCheckedChange = {
                            isPersonFavorite.value = it
                            onClickFavorite(person)
                        },
                        modifier = Modifier
                            .weight(0.2f)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            imageVector = if (isPersonFavorite.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                            contentDescription = stringResource(R.string.person_add_to_favorite_cd),
                            tint = if (isPersonFavorite.value) Color.Red else Color.White
                        )
                    }
                }
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
                ) {
                    Subtitle1Text(
                        text = stringResource(id = R.string.person_last_known_location_text),
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(text = personState.location.name)
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewCharacterItem() {
    CharacterItem(person = SingleCharacter(name = "Test User"))
}