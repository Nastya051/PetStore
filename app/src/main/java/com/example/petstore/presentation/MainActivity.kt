package com.example.petstore.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.petstore.presentation.navigation.MainNavigationController
import com.example.petstore.presentation.ui.theme.PetStoreTheme
import com.example.petstore.viewmodels.UserViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PetStoreTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainNavigationController(navController = navController)
                }
            }
        }
    }
}