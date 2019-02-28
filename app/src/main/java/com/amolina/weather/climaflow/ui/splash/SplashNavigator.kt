package com.amolina.weather.climaflow.ui.splash


/**
 * Created by Amolina on 02/02/17.
 */

interface SplashNavigator {

    fun handleError(throwable: Throwable)

    fun openMainActivity()

    fun loadCities()

}
