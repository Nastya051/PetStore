package com.example.petstore.presentation.ui.custom_views.textfields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petstore.R

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    textValue: String,
    onValueChanged: (String) -> Unit,
    maxLength: Int = 40,
    enabled: Boolean = true,
    isPassword: Boolean = false,
    placeholder: String,
    trailIcon: Int = 0,
    iconTint: Color = MaterialTheme.colorScheme.tertiary,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    mask: VisualTransformation = VisualTransformation.None
) {

    var icon by remember { mutableIntStateOf(trailIcon) }
    var isPass by remember { mutableStateOf(isPassword) }
    val trailingIconView = @Composable {
        IconButton(
            onClick = {
                if (icon == R.drawable.ic_eye_slash_24) {
                    icon = R.drawable.ic_eye_24
                    isPass = false
                } else if (icon == R.drawable.ic_eye_24) {
                    icon = R.drawable.ic_eye_slash_24
                    isPass = true
                }
            },
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Trail icon",
                tint = iconTint
            )
        }
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .border(
                shape = RoundedCornerShape(60.dp),
                color = MaterialTheme.colorScheme.tertiary,
                width = 2.dp
            ),
        value = textValue,
        onValueChange = {
            if (it.length <= maxLength)
                onValueChanged(it)
        },
        enabled = enabled,
        placeholder = {
            Text(
                text = placeholder,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        trailingIcon = {
            if (trailIcon != 0)
                trailingIconView()
        },
        textStyle = TextStyle(fontWeight = FontWeight.W500, fontSize = 18.sp),
        visualTransformation = if (isPass) PasswordVisualTransformation() else mask,
        isError = isError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = RoundedCornerShape(60.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.10f),
            focusedTextColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedPlaceholderColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.10f),
            unfocusedTextColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            errorContainerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.15f),
            errorTextColor = MaterialTheme.colorScheme.background,
            errorIndicatorColor = MaterialTheme.colorScheme.outline
        )
    )
}