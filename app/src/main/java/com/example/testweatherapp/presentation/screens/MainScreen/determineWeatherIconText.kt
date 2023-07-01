package com.example.testweatherapp.presentation.screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testweatherapp.network.model.WeatherX

/**
 * Displays a row with a weather icon and a description text based on the provided WeatherX object.
 *
 * @param weatherX WeatherX object containing the icon code and description text.
 * @param modifier Modifier to apply to this layout's Composable.
 */
@Composable
fun DetermineWeatherIconAndText(weatherX: WeatherX, modifier: Modifier = Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        WeatherIcon(iconCode = weatherX.icon)
        Text(text = weatherX.description, style = MaterialTheme.typography.bodyLarge)
    }
}

/**
 * Displays a weather icon based on the provided icon code. The icon is fetched asynchronously.
 *
 * @param iconCode Code of the weather icon to display.
 * @param modifier Modifier to apply to this layout's Composable.
 */
@Composable
fun WeatherIcon(iconCode: String, modifier: Modifier = Modifier.size(30.dp)) {
    AsyncImage(
        model = "https://openweathermap.org/img/wn/${iconCode}@2x.png",
        contentDescription = "Weather Icon",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}