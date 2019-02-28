package com.amolina.weather.climaflow.di.module

import com.amolina.weather.climaflow.ui.location.AndroidLocationProvider
import com.amolina.weather.climaflow.ui.location.LocationProvider
import dagger.Binds
import dagger.Module

@Module
abstract class LocationModule {
    @Binds
    abstract fun locationProvider(androidLocationProvider: AndroidLocationProvider): LocationProvider
}