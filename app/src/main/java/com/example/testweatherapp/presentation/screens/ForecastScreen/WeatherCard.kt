package com.example.testweatherapp.presentation.screens.ForecastScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testweatherapp.R
import com.example.testweatherapp.common.convertUnixToTime
import com.example.testweatherapp.network.model.Current

/**
 * A composable that displays the current weather data in a card format.
 *
 * @param weatherData The [Current] data object containing the current weather data.
 * @param tint An optional [Color] parameter for setting the background color of the card.
 * @param modifier An optional [Modifier] for the composable.
 */
@Composable
fun WeatherCard(
    weatherData: Current,
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF384266)
) {
    Card(
        backgroundColor = tint,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 64.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Saint-Petersburg",
                    color = Color.White,
                )
                Text(
                    text = "Today at ${convertUnixToTime(weatherData.dt)}",
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.detailed_screen_photo),
                contentDescription = null,
                modifier = Modifier.width(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${weatherData.temp.toInt()}°C",
                fontSize = 50.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = weatherData.weather[0].description,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                WeatherDataDisplay(
                    value = weatherData.pressure,
                    unit = "hpa",
                    icon = ImageVector.vectorResource(id = R.drawable.pressure_alt_svgrepo_com),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                WeatherDataDisplay(
                    value = weatherData.humidity,
                    unit = "%",
                    icon = ImageVector.vectorResource(id = R.drawable.humidity_svgrepo_com),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
                WeatherDataDisplay(
                    value = weatherData.wind_speed.toInt(),
                    unit = "m/s",
                    icon = ImageVector.vectorResource(id = R.drawable.wind_svgrepo_com),
                    iconTint = Color.White,
                    textStyle = TextStyle(color = Color.White)
                )
            }
        }
    }
}
