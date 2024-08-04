package com.example.petstore.presentation.ui.custom_views.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun TextHint(modifier: Modifier = Modifier, text: Int, color: Color) {
    Text(
        modifier = modifier,
        text = stringResource(id = text),
        color = color,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}