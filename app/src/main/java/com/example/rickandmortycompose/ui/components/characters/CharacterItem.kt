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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
    val personState = rememberSaveable { mutableStateOf(person) }
    val isPersonFavorite = rememberSaveable { mutableStateOf(person.isFavorite) }
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
                CharacterNameAndIsFavorite(
                    modifier = Modifier.fillMaxWidth(),
                    person = person,
                    isPersonFavorite = isPersonFavorite.value,
                    onClickFavoriteBtn = {
                        personState.value = personState.value.copy(isFavorite = it)
                        isPersonFavorite.value = it
                        onClickFavorite(personState.value)
                    }
                )
                CharacterStatusAndGender(
                    person = person, modifier = Modifier
                        .fillMaxWidth()
                )
                CharacterLastKnowLocation(
                    person = person,
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }
}

@Composable
fun CharacterNameAndIsFavorite(
    modifier: Modifier = Modifier,
    person: SingleCharacter,
    isPersonFavorite: Boolean = false,
    onClickFavoriteBtn: (isPersonFavorite: Boolean) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        H2Text(
            modifier = Modifier.weight(0.8f),
            text = person.name
        )
        IconToggleButton(
            checked = isPersonFavorite,
            onCheckedChange = {
                onClickFavoriteBtn(it)
            },
            modifier = Modifier
                .weight(0.2f)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = if (isPersonFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                contentDescription = stringResource(R.string.person_add_to_favorite_cd),
                tint = if (isPersonFavorite) Color.Red else Color.White
            )
        }
    }
}

@Composable
fun CharacterStatusAndGender(modifier: Modifier = Modifier, person: SingleCharacter) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (person.status == "Alive") {
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
        NormalText(text = "${person.status} - ${person.species}")
    }
}

@Composable
fun CharacterLastKnowLocation(modifier: Modifier = Modifier, person: SingleCharacter) {
    Row(
        modifier = modifier
            .padding(top = 8.dp)
    ) {
        Subtitle1Text(
            text = stringResource(id = R.string.person_last_known_location_text),
            modifier = Modifier.fillMaxWidth(),
        )
    }
    Row(
        modifier = modifier,
    ) {
        Text(text = person.location.name)
    }
}

@Preview
@Composable
fun PreviewCharacterItem() {
    CharacterItem(person = SingleCharacter(name = "Test User"))
}