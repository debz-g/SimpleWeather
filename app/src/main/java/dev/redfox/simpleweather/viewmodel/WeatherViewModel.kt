package dev.redfox.simpleweather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.redfox.simpleweather.model.Weather
import dev.redfox.simpleweather.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository):ViewModel(){

    val resp = MutableLiveData<Weather>()
    val weatherResp:LiveData<Weather>
    get() = resp

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        repository.getWeather().let { response ->
            if(response.isSuccessful){
                resp.postValue(
                    response.body()
                )
            }else {
                Log.d("Error","getWeather Ereror Response: ${response.message()}")
            }
        }
    }
}