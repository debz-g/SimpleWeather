package dev.redfox.simpleweather.api

import dev.redfox.simpleweather.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Bengaluru")
    suspend fun getWeather():Response<Weather>
}