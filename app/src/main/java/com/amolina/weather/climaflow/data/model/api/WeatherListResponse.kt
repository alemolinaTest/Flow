package com.amolina.weather.climaflow.data.model.api

data class WeatherListResponse(

    var id: Int,
    var main: String,
    var description: String,
    var icon: String
) {
    constructor() : this(0, "", "", "")
}
