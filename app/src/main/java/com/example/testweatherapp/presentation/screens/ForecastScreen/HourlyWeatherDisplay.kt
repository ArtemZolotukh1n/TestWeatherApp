package com.example.testweatherapp.presentation.screens.ForecastScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testweatherapp.common.convertUnixToTime
import com.example.testweatherapp.network.model.Hourly
import com.example.testweatherapp.presentation.screens.MainScreen.WeatherIcon
import kotlin.math.roundToInt

@Composable
fun HourlyWeatherDisplay(
    weatherData: Hourly,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = convertUnixToTime(weatherData.dt),
            style = MaterialTheme.typography.bodyMedium
        )
        WeatherIcon(weatherData.weather[0].icon, Modifier.size(64.dp))
        Text(
            text = "${weatherData.temp.roundToInt()}°C",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}