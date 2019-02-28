package com.amolina.weather.climaflow.data.remote

import com.amolina.weather.climaflow.data.model.api.*

import io.reactivex.Observable

/**
 * Created by Amolina on 02/02/17.
 */

interface ApiHelper {

    val apiHeader: ApiHeader

    fun getForecastApiCall(cityId: String): Observable<ForecastResponse>

    fun getCurrentWeatherApiCall(cityId: String): Observable<WeatherResponse>
}
