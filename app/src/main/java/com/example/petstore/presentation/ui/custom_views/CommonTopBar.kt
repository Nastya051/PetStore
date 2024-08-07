package com.example.petstore.presentation.ui.custom_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petstore.R
import com.example.petstore.presentation.navigation.LocalNavController
import com.example.petstore.presentation.navigation.Route

@Composable
fun CommonTopBar(
    modifier: Modifier = Modifier,
    leftIcon: Int,
    onClickLeft: () -> Unit,
    rightIcon: Int,
    onClickRight: () -> Unit
) {
    val navController = LocalNavController.current!!
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onClickLeft() }, modifier = Modifier.padding(
                start = 8.dp, top = 10.dp, bottom = 10.dp
            )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = leftIcon),
                contentDescription = "Left icon",
                tint = MaterialTheme.colorScheme.tertiaryContainer
            )
        }

        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.app_name)),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.W600,
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
        ) {
            navController.navigate(Route.MainScreen.path)
        }


        IconButton(
            onClick = { onClickRight() },
            enabled = rightIcon != 0,
            modifier = Modifier.padding(end = 8.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = rightIcon),
                contentDescription = "Right icon",
                tint = if (rightIcon != 0) MaterialTheme.colorScheme.tertiaryContainer
                else MaterialTheme.colorScheme.primary
            )
        }
    }
}