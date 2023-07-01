package com.example.testweatherapp.presentation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testweatherapp.R
import com.example.testweatherapp.navigation.Screen

/**
 * Represents the bottom navigation bar of the application with navigation items to different screens.
 *
 * @param navController NavController for handling navigation between screens.
 */

@Composable
fun AppsBottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.details_so_svgrepo_com),
                    contentDescription = "Details",
                    tint = Color(0xFFF7F1F1),
                    modifier = Modifier.size(20.dp)

                )
            },
            label = { Text("Details") },
            selected = navController.currentDestination?.route == Screen.DetailsScreen.route,
            onClick = {
                navController.navigate(Screen.DetailsScreen.route) {
                    popUpTo(Screen.MainScreen.route) { inclusive = true }
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.main_screen_icon),
                    contentDescription = "Main",
                    tint = Color(0xFFF7F1F1),
                    modifier = Modifier.size(20.dp)

                )
            },
            label = { Text("Main") },
            selected = navController.currentDestination?.route == Screen.MainScreen.route,
            onClick = {
                navController.navigate(Screen.MainScreen.route) {
                    popUpTo(Screen.MainScreen.route) { inclusive = true }
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.forecast_thermometer_weather_svgrepo_com),
                    contentDescription = "Forecast",
                    tint = Color(0xFFF7F1F1),
                    modifier = Modifier.size(20.dp)

                )
            },
            label = { Text("Forecast") },
            selected = navController.currentDestination?.route == Screen.ForecastScreen.route,
            onClick = {
                navController.navigate(Screen.ForecastScreen.route) {
                    popUpTo(Screen.MainScreen.route) { inclusive = true }
                }
            }
        )
    }
}