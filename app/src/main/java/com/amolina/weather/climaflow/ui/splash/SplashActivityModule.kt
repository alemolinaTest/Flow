package com.amolina.weather.climaflow.ui.splash

import com.amolina.weather.climaflow.data.DataManager
import com.amolina.weather.climaflow.rx.SchedulerProvider
import com.amolina.weather.climaflow.ui.location.LocationProvider

import dagger.Module
import dagger.Provides


/**
 * Created by Amolina on 02/02/17.
 */
@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider,
        locationProvider: LocationProvider
    ): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider, locationProvider)
    }

}
