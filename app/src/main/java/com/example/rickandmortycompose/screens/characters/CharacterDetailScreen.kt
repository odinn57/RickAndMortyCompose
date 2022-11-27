package com.example.rickandmortycompose.screens.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.model.SingleCharacter
import com.example.rickandmortycompose.ui.components.NormalText
import com.example.rickandmortycompose.ui.components.Subtitle1Text
import com.example.rickandmortycompose.ui.components.characters.CharacterDetail
import com.example.rickandmortycompose.ui.theme.Black
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.White

@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    person: SingleCharacter?,
    onFavoriteClick: (person: SingleCharacter) -> Unit = {}
) {
    Scaffold(backgroundColor = CardBackground) { padding ->
        Column(modifier = modifier.padding(padding)) {
            if (person != null) {
                CharacterDetail(person = person,
                    onClickFavorite = { onFavoriteClick(person) }
                )
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column() {
                        Subtitle1Text(text = stringResource(id = R.string.something_wrong))
                        Button(
                            modifier = Modifier.padding(top = 4.dp),
                            onClick = { navController.popBackStack() },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Black,
                                contentColor = White
                            )
                        ) {
                            NormalText(text = stringResource(id = R.string.back_text))
                        }
                    }
                }
            }
        }
    }
}
