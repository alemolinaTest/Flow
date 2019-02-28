package com.amolina.weather.climaflow.ui.cities

import android.databinding.ObservableField

/**
 * Created by Amolina on 02/02/17.
 */

class CitiesItemModel(name: String, id: Int) {

    lateinit var mListener: ShowDaysListener

    fun setListener(listener: ShowDaysListener) {
        mListener = listener
    }

    fun onShowDaysClick() {
        mListener.onShowCitiesClick()
    }

    interface ShowDaysListener {
        fun onShowCitiesClick()
    }

    var cityName = ObservableField<String>(name)
    var cityId = ObservableField<Int>(id)

}
