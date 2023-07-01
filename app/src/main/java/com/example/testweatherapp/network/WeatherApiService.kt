package com.example.testweatherapp.network

import com.example.testweatherapp.network.model.WeatherDto
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface defining the endpoint for fetching weather forecast data
 * from the OpenWeatherMap API using Retrofit annotations.
 */

interface WeatherApiService {
    @GET("onecall")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("exclude") exclude: String = "minutely,alerts",
        @Query("appid") appId: String
    ): WeatherDto
}

/**
 * Handles communication with the OpenWeatherMap API service using Retrofit
 * for HTTP requests and Moshi for JSON conversion, providing a method to get
 * a forecast for a specific latitude and longitude.
 */

class WeatherApi(moshi: Moshi, private val apiKey: String) {
    private val retrofit: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(WeatherApiService::class.java)
    }

    suspend fun getForecast(lat: Double, lon: Double): WeatherDto? {
        return try {
            withContext(Dispatchers.IO) {
                retrofit.getForecast(lat, lon, appId = apiKey)
            }
        } catch (e: Exception) {
            // Log the error here if needed
            throw e
        }
    }
}