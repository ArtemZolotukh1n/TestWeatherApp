package com.example.testweatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.testweatherapp.navigation.NavGraph
import com.example.testweatherapp.presentation.AppsBottomNavigationBar
import com.example.testweatherapp.presentation.theme.TestWeatherAppTheme
import com.example.testweatherapp.presentation.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            TestWeatherAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { AppsBottomNavigationBar(navController) }
                ) {
                    NavGraph(
                        navController = navController,
                        weatherViewModel = hiltViewModel()
                    )
                }
            }

        }
    }

}

