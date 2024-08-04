package com.example.petstore.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petstore.R
import com.example.petstore.presentation.navigation.LocalNavController
import com.example.petstore.presentation.navigation.Route
import com.example.petstore.presentation.ui.custom_views.texts.AuthText
import com.example.petstore.presentation.ui.custom_views.buttons.BottomQuestion
import com.example.petstore.presentation.ui.custom_views.buttons.CommonButton
import com.example.petstore.presentation.ui.custom_views.textfields.CommonTextField

@Composable
fun LogInScreen() {
    val navController = LocalNavController.current!!
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var buttonEnable by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(10.dp)
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AuthText(
                textResource = R.string.username,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )

            CommonTextField(
                textValue = username,
                onValueChanged = { username = it },
                placeholder = stringResource(id = R.string.enterUsername),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            AuthText(
                textResource = R.string.password,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            CommonTextField(
                textValue = password,
                onValueChanged = { password = it },
                placeholder = stringResource(id = R.string.enterPassword),
                isPassword = true,
                trailIcon = R.drawable.ic_eye_slash_24,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            )

            CommonButton(
                text = stringResource(id = R.string.logIn),
                enabled = buttonEnable,
                onClick = { /*запрос логин и переход на главную*/ },
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
        }

        BottomQuestion(
            textQuestion = R.string.questionNoAcc, textButton = R.string.signUp,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            navController.navigate(Route.SignUpScreen.path)
        }
    }

    LaunchedEffect(username, password) {
        buttonEnable = username.isNotEmpty() && password.isNotEmpty()
    }
}