package com.example.testweatherapp.presentation.screens.ForecastScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.testweatherapp.common.Result
import com.example.testweatherapp.presentation.viewmodels.WeatherViewModel

/**
 * A composable that displays the forecast screen. It shows either loading, success or error state
 * based on the [viewModel]'s [weatherData] state.
 *
 * @param viewModel The [WeatherViewModel] which contains the [weatherData].
 */
@Composable
fun ForecastScreen(viewModel: WeatherViewModel) {
    val weatherData = viewModel.weatherData.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF293251), Color(0xFF232A47)),
                    start = Offset(x = 0f, y = Float.POSITIVE_INFINITY),
                    end = Offset(x = Float.POSITIVE_INFINITY, y = 0f)
                )
            )
    ) {
        when (weatherData) {
            is Result.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is Result.Success -> {
                // Check if data is not null
                val data = weatherData.data
                if (data != null) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                WeatherCard(weatherData = data.current)
                                WeatherForecast(hourlyWeatherData = data.hourly)
                            }
                        }
                    }
                } else {
                    Text(text = "No forecast data available")
                }
            }

            is Result.Error -> {
                Text(text = weatherData.message, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
