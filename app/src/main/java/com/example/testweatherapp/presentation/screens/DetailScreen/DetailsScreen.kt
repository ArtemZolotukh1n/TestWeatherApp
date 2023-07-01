package com.example.testweatherapp.presentation.screens.DetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.testweatherapp.R
import com.example.testweatherapp.common.Result
import com.example.testweatherapp.common.convertUnixToTime
import com.example.testweatherapp.presentation.viewmodels.WeatherViewModel

/**
 * A composable that displays the details screen. It shows either loading, success or error state
 * based on the [viewModel]'s [weatherData] state.
 *
 * @param viewModel The [WeatherViewModel] which contains the [weatherData].
 */
@Composable
fun DetailsScreen(viewModel: WeatherViewModel) {
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
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            is Result.Success -> {
                val data = weatherData.data
                if (data != null) {
                    val currentWeather = data.current
                    val weather = currentWeather.weather[0]
                    val sunriseTime = convertUnixToTime(currentWeather.sunrise)
                    val sunsetTime = convertUnixToTime(currentWeather.sunset)
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 32.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.detailed_screen_photo),
                                    contentDescription = null,
                                    modifier = Modifier.size(256.dp)
                                )
                                Text(
                                    text = "${currentWeather.temp.toInt()}°c",
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Text(
                                    text = "Saint-Petersburg",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 40.dp)
                                )
                                Text(
                                    text = weather.description.capitalize(),
                                    style = MaterialTheme.typography.bodySmall,
                                )
                                DetailItemRow {
                                    DetailItemColumn(
                                        "${currentWeather.wind_speed.toInt()} m/s",
                                        ImageVector.vectorResource(R.drawable.wind_svgrepo_com),
                                        "Wind Flow",
                                    )

                                    DetailItemColumn(
                                        "${currentWeather.pressure} hPa",
                                        ImageVector.vectorResource(R.drawable.pressure_alt_svgrepo_com),
                                        "Pressure",
                                    )

                                    DetailItemColumn(
                                        "${currentWeather.humidity}%",
                                        ImageVector.vectorResource(R.drawable.humidity_svgrepo_com),
                                        "Humidity",
                                    )
                                }

                                DetailItemRow {
                                    DetailItemColumn(
                                        sunriseTime,
                                        ImageVector.vectorResource(R.drawable.sunrise_up_svgrepo_com),
                                        "Sunrise",
                                    )

                                    DetailItemColumn(
                                        "${currentWeather.feels_like.toInt()}°c",
                                        ImageVector.vectorResource(R.drawable.temperature_feels_like_svgrepo_com),
                                        "Feels Like",
                                    )
                                    DetailItemColumn(
                                        "${currentWeather.uvi}",
                                        ImageVector.vectorResource(R.drawable.uv_index_alt_svgrepo_com),
                                        "UV Index",
                                    )

                                    DetailItemColumn(
                                        "${currentWeather.visibility / 1000} km",
                                        ImageVector.vectorResource(R.drawable.visibility_svgrepo_com),
                                        "Visibility",
                                    )

                                    DetailItemColumn(
                                        sunsetTime,
                                        ImageVector.vectorResource(R.drawable.sunset_down_svgrepo_com),
                                        "Sunset",
                                    )
                                }

                            }
                        }
                    }
                }
            }

            is Result.Error -> {
                Text(
                    text = "Error: ${weatherData.message}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
