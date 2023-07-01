package com.example.testweatherapp.repository

import android.util.Log
import com.example.testweatherapp.network.WeatherApi
import com.example.testweatherapp.network.model.WeatherDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository that handles data operations in WeatherApp and provides a clean API to the rest of the app.
 * It works with a WeatherApi to get data.
 *
 * @property api WeatherApi object responsible for handling network requests.
 */

class WeatherRepository(
    private val api: WeatherApi,
) {
    /**
     * Fetches weather data for a specific location by its latitude and longitude.
     * The default location is 59.55 latitude and 30.20 longitude (Saint-Petersburg).
     *
     * @param lat Latitude of the location. Default value is 59.55.
     * @param lon Longitude of the location. Default value is 30.20.
     * @return Weather data for the specified location as a WeatherDto object, or null if fetching fails.
     */

    suspend fun getWeather(lat: Double = 59.55, lon: Double = 30.20): WeatherDto? {
        return withContext(Dispatchers.IO) {
            try {
                api.getForecast(lat, lon)
            } catch (e: Exception) {
                Log.d("weatherFetch", e.toString())
                throw e
            }
        }
    }
}