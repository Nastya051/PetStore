package com.example.petstore.presentation.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.petstore.R
import com.example.petstore.presentation.navigation.LocalNavController
import com.example.petstore.presentation.navigation.Route
import com.example.petstore.presentation.ui.custom_views.buttons.CommonButton

@Composable
fun StartScreen() {
    val navController = LocalNavController.current!!
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.start_cat)
    )
    var visible by remember { mutableStateOf(false) }
    val progress by animateLottieCompositionAsState(composition)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = stringResource(id = R.string.startHeader),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp)
                .fillMaxWidth()
        )
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.padding(end = 40.dp)
        )

        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(
                expandFrom = Alignment.Top,
                animationSpec = tween(durationMillis = 1000)
            )
                    + fadeIn(animationSpec = tween(durationMillis = 1000)),
            exit = shrinkVertically(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            ) {
                CommonButton(
                    text = stringResource(id = R.string.logIn),
                    onClick = { navController.navigate(Route.LogInScreen.path) },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                CommonButton(
                    text = stringResource(id = R.string.signUp),
                    onClick = { navController.navigate(Route.SignUpScreen.path) },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ClickableText(
                        text = AnnotatedString(stringResource(id = R.string.skip)),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        ),
                        onClick = {})
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrows_right_24),
                        contentDescription = "Arrows",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }

            }

        }
    }

    LaunchedEffect(progress) {
        if (progress >= 0.5f) {
            visible = true
        }
    }
}