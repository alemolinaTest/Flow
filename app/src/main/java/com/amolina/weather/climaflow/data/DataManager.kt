package com.amolina.weather.climaflow.data


import com.amolina.weather.climaflow.data.local.db.DbHelper
import com.amolina.weather.climaflow.data.model.api.ForecastResponse
import com.amolina.weather.climaflow.data.remote.ApiHelper
import io.reactivex.Observable

/**
 * Created by Amolina on 02/02/17.
 */

interface DataManager : DbHelper, ApiHelper {

    fun updateApiHeader(accessToken: String)
    fun saveForecastResponse(forecast: ForecastResponse): Observable<Boolean>

}
