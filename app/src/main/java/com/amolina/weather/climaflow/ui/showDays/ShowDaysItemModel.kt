package com.amolina.weather.climaflow.ui.showDays

import android.databinding.ObservableField

/**
 * Created by Amolina on 02/02/17.
 */

class ShowDaysItemModel(imageUrl: String, city: String, temp: String, tempMin: String, tempMax: String, time: String) {

    var imageUrl = ObservableField<String>(imageUrl)
    var city = ObservableField<String>(city)
    var temp = ObservableField<String>(temp)
    var tempMin = ObservableField<String>(tempMin)
    var tempMax = ObservableField<String>(tempMax)
    var time = ObservableField<String>(time)

}
