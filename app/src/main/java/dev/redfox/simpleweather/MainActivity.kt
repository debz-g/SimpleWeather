package dev.redfox.simpleweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.redfox.simpleweather.databinding.ActivityMainBinding
import dev.redfox.simpleweather.viewmodel.WeatherViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.weatherResp.observe(this,{weather ->
            binding.apply {

                tvCityName.text = "Bengaluru"
                tvTemperature.text = weather.temperature
                tvDescription.text = weather.description
                tvWind.text = weather.wind

                val forecast1 = weather.forecast[0]
                val forecast2 = weather.forecast[1]
                val forecast3 = weather.forecast[2]

                tvForecast1.text = "${forecast1.temperature}/${forecast1.wind}"
                tvForecast1.text = "${forecast2.temperature}/${forecast2.wind}"
                tvForecast1.text = "${forecast2.temperature}/${forecast3.wind}"

            }
        })

    }
}