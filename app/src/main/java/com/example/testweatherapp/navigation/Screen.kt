package com.example.testweatherapp.navigation

/**
 * Represents different screens in the application with their associated routes for navigation.
 */

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailsScreen : Screen("details_screen")
    object ForecastScreen : Screen("forecast_screen")
}
