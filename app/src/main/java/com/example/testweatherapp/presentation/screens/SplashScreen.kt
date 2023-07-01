package com.example.testweatherapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testweatherapp.R
import kotlinx.coroutines.delay

// Wont be used - because I have made a custom xml loading screen
@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.splash_loading),
                contentDescription = "App Icon",
                modifier = Modifier.size(100.dp),
                tint = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
    }

    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate("main_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }
}
