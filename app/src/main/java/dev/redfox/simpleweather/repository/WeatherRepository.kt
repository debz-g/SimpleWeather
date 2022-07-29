package dev.redfox.simpleweather.repository

import dev.redfox.simpleweather.api.ApiService
import javax.inject.Inject

class WeatherRepository

    @Inject
    constructor(private val apiService: ApiService){
        suspend fun getWeather() = apiService.getWeather()
    }
