package com.example.testweatherapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testweatherapp.common.Result
import com.example.testweatherapp.network.model.WeatherDto
import com.example.testweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the MainScreen, using a WeatherRepository to fetch weather
 * data held in a MutableStateFlow. Fetching of data is initiated upon ViewModel's initialization.
 */

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val _weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weatherData = MutableStateFlow<Result<WeatherDto?>>(Result.Loading)
    val weatherData: StateFlow<Result<WeatherDto?>> = _weatherData

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {
                val data = _weatherRepository.getWeather()
                _weatherData.value = Result.Success(data)
            } catch (e: Exception) {
                _weatherData.value = Result.Error("Failed to fetch weather data.")
            }
        }
    }
}