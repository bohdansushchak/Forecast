package com.example.forecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.forecast.R
import com.example.forecast.data.ApixuWeatherApiService
import com.example.forecast.data.network.ConectivityInterceptorImpl
import com.example.forecast.data.network.ConnectivityInterceptor
import com.example.forecast.internal.NoConnectivityException
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)

        val apiService = ApixuWeatherApiService(ConectivityInterceptorImpl(context!!))

        GlobalScope.launch(Dispatchers.Main) {

            try {
                val currentWeatherResponce = apiService.getCurrentWeather("Rzeszow").await()

                textView.text = currentWeatherResponce.toString()
            }
            catch (exception: NoConnectivityException){

                Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show()
            }

        }



    }

}
