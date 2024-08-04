package com.example.petstore.presentation.ui.custom_views.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AuthText(textResource: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = textResource),
        fontWeight = FontWeight.W600,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    )
}