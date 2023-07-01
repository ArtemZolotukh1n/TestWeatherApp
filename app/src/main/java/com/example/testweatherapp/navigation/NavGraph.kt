package com.example.testweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testweatherapp.presentation.screens.DetailScreen.DetailsScreen
import com.example.testweatherapp.presentation.screens.ForecastScreen.ForecastScreen
import com.example.testweatherapp.presentation.screens.MainScreen.MainScreen
import com.example.testweatherapp.presentation.viewmodels.WeatherViewModel

/**
 * Defines the navigation graph for the application, using a NavHostController to
 * manage the navigation between the MainScreen, DetailsScreen, and ForecastScreen.
 */
@Composable
fun NavGraph(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen(viewModel = weatherViewModel)
        }

        composable(Screen.DetailsScreen.route) {
            DetailsScreen(viewModel = weatherViewModel)
        }

        composable(Screen.ForecastScreen.route) {
            ForecastScreen(viewModel = weatherViewModel)
        }

        /*composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }*/
    }
}