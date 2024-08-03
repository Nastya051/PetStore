package com.example.petstore.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.petstore.R
import com.example.petstore.presentation.navigation.LocalNavController
import com.example.petstore.presentation.navigation.Route
import com.example.petstore.presentation.ui.custom_views.AuthText
import com.example.petstore.presentation.ui.custom_views.BottomQuestion
import com.example.petstore.presentation.ui.custom_views.CommonButton
import com.example.petstore.presentation.ui.custom_views.CommonTextField

@Composable
fun SignUpScreen() {
    val navController = LocalNavController.current!!
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        bottomBar = {
            BottomQuestion(
                textQuestion = R.string.questionIsAcc, textButton = R.string.logIn,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                navController.navigate(Route.LogInScreen.path)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(10.dp)
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                AuthText(
                    textResource = R.string.concoctUsername,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
            }

            item {
                CommonTextField(
                    textValue = username,
                    onValueChanged = { newText -> username = newText },
                    placeholder = stringResource(id = R.string.enterUsername),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                AuthText(
                    textResource = R.string.concoctPassword,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CommonTextField(
                    textValue = password,
                    onValueChanged = { newText -> password = newText },
                    placeholder = stringResource(id = R.string.enterPassword),
                    isPassword = true,
                    trailIcon = R.drawable.ic_eye_slash_24,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                AuthText(
                    textResource = R.string.name,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CommonTextField(
                    textValue = name,
                    onValueChanged = { newText -> name = newText },
                    placeholder = stringResource(id = R.string.enterName),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                AuthText(
                    textResource = R.string.surname,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CommonTextField(
                    textValue = surname,
                    onValueChanged = { newText -> surname = newText },
                    placeholder = stringResource(id = R.string.enterSurname),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                AuthText(
                    textResource = R.string.email,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CommonTextField(
                    textValue = email,
                    onValueChanged = { newText -> email = newText },
                    placeholder = stringResource(id = R.string.enterEmail),
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                AuthText(
                    textResource = R.string.phoneNumber,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CommonTextField(
                    textValue = phone,
                    onValueChanged = { newText -> phone = newText },
                    placeholder = stringResource(id = R.string.enterPhoneNumber),
                    keyboardType = KeyboardType.Phone,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
            item {
                CommonButton(
                    text = stringResource(id = R.string.signUp),
                    onClick = { /*запрос создания юзера и переход на главную*/ },
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}