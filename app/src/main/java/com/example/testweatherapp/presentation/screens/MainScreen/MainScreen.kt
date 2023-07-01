package com.example.testweatherapp.presentation.screens.MainScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.testweatherapp.R
import com.example.testweatherapp.common.Result
import com.example.testweatherapp.presentation.viewmodels.WeatherViewModel

/**
 * Represents the main screen of the application. It displays the current weather data for a specific location.
 *
 * @param viewModel ViewModel associated with this screen, handling its logic and providing necessary data.
 */

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(viewModel: WeatherViewModel) {
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.city_name_icon),
                    contentDescription = null,
                    tint = Color.White
                )

                Text(
                    text = "Saint-Petersburg",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)

                )
            }

            when (weatherData) {
                is Result.Loading -> {
                    CircularProgressIndicator()
                }

                is Result.Success -> {
                    val data = weatherData.data
                    if (data != null) {
                        Log.d("MainScreen", data.current.toString())
                        Log.d("MainScreen", data.daily.toString())
                        Log.d("MainScreen", data.hourly.toString())
                        Text(
                            text = "${data.current.temp.toInt()}°C",
                            style = MaterialTheme.typography.titleLarge,
                        )

                        DetermineWeatherIconAndText(
                            data.current.weather[0],
                            Modifier.padding(top = 8.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            WeatherDetail(
                                icon = ImageVector.vectorResource(R.drawable.wind_svgrepo_com),
                                label = "Wind Speed: ",
                                value = "${data.current.wind_speed} m/s",
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                            WeatherDetail(
                                icon = ImageVector.vectorResource(R.drawable.pressure_alt_svgrepo_com),
                                label = "Pressure: ",
                                value = "${data.current.pressure} hPa",
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                            WeatherDetail(
                                icon = ImageVector.vectorResource(R.drawable.humidity_svgrepo_com),
                                label = "Humidity: ",
                                value = "${data.current.humidity} %",
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }

                    } else {
                        Text(
                            text = "Weather data is null",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                is Result.Error -> {
                    Text(
                        text = "Error: ${weatherData.message}",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}
