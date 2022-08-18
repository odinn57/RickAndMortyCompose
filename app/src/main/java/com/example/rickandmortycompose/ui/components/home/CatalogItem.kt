package com.example.rickandmortycompose.ui.components.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.CardBackground
import com.example.rickandmortycompose.ui.theme.White

@Composable
fun CatalogItem(
    modifier: Modifier = Modifier,
    @DrawableRes imgRes: Int = R.drawable.ic_foto,
    @StringRes titleRes: Int = R.string.empty_string,
    onCardClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(6.dp),
        elevation = 5.dp,
        backgroundColor = CardBackground

    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(imgRes),
                contentDescription = stringResource(id = titleRes),
                modifier = Modifier.heightIn(200.dp)
            )
            Text(
                text = stringResource(id = titleRes),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(
                        color = CardBackground.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(10.dp)
                    ),
                style = MaterialTheme.typography.h3,
                color = White,
            )
        }
    }
}

