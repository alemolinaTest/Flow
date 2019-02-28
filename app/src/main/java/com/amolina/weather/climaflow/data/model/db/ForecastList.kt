package com.amolina.weather.climaflow.data.model.db

import android.arch.persistence.room.*
import com.amolina.weather.climaflow.data.model.api.CloudListResponse
import com.amolina.weather.climaflow.data.model.api.MainListResponse
import com.amolina.weather.climaflow.data.model.api.WeatherListResponse
import com.amolina.weather.climaflow.data.model.api.WindListResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Amolina on 10/02/2019.
 */
@Entity(
    tableName = "forecast_list",
    primaryKeys = ["dt", "city_id"],
    indices = [(Index(value = ["dt", "city_id"], unique = true))],
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = ["id"],
            childColumns = ["city_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Forecast::class,
            parentColumns = ["city_id"],
            childColumns = ["city_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ForecastList(

    @ColumnInfo(name = "dt") var dt: Int,

    @ColumnInfo(name = "city_id")
    var city_id: Long,

    @ColumnInfo(name = "dt_txt") var dtTxt: String = ""

)