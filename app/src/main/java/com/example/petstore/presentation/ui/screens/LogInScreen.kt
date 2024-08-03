package com.example.petstore.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.petstore.R
import com.example.petstore.presentation.navigation.LocalNavController
import com.example.petstore.presentation.navigation.Route
import com.example.petstore.presentation.ui.custom_views.BottomQuestion
import com.example.petstore.presentation.ui.custom_views.CommonButton
import com.example.petstore.presentation.ui.custom_views.CommonTextField

@Composable
fun LogInScreen() {
    val navController = LocalNavController.current!!
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
            Text(
                text = stringResource(id = R.string.username),
                fontWeight = FontWeight.W600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            CommonTextField(
                textValue = username,
                onValueChanged = { username = it },
                placeholder = stringResource(id = R.string.enterUsername),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.password),
                fontWeight = FontWeight.W600,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
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

}