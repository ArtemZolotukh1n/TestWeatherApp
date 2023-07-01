package com.example.testweatherapp.presentation.screens.ForecastScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testweatherapp.network.model.Hourly

@Composable
fun WeatherForecast(
    hourlyWeatherData: List<Hourly>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Hourly Forecast",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(hourlyWeatherData.filterIndexed { index, _ -> index % 2 == 0 }) { weatherData ->
                HourlyWeatherDisplay(
                    weatherData = weatherData,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }

}