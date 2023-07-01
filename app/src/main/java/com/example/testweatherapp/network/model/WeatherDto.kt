package com.example.testweatherapp.network.model

/**
 * Data Transfer Object (DTO) representing the structure of the weather data
 * received from the API, including current, daily, hourly weather, and geographical and timezone details.
 */

data class WeatherDto(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)