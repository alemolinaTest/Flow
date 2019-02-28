package com.amolina.weather.climaflow.ui.main

import android.arch.lifecycle.ViewModelProvider

import com.amolina.weather.climaflow.ViewModelProviderFactory
import com.amolina.weather.climaflow.data.DataManager
import com.amolina.weather.climaflow.rx.SchedulerProvider
import com.amolina.weather.climaflow.ui.cities.CitiesViewModel
import com.amolina.weather.climaflow.ui.location.LocationProvider
import com.amolina.weather.climaflow.ui.show.ShowViewModel
import com.amolina.weather.climaflow.ui.showDays.ShowDaysViewModel
import com.amolina.weather.climaflow.ui.splash.SplashViewModel

import dagger.Module
import dagger.Provides

/**
 * Created by Amolina on 02/02/17.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager,
                                      schedulerProvider: SchedulerProvider): MainViewModel {
        return MainViewModel(dataManager, schedulerProvider)
    }

    @Provides
    internal fun provideShowViewModelProviderFactory(showViewModel: ShowViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(showViewModel)
    }

    @Provides
    internal fun provideShowDaysViewModelProviderFactory(showDaysViewModel: ShowDaysViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(showDaysViewModel)
    }

    @Provides
    internal fun provideShowViewModel(dataManager: DataManager,
                                  schedulerProvider: SchedulerProvider): ShowViewModel {
        return ShowViewModel(dataManager, schedulerProvider)
    }

    @Provides
    internal fun provideShowDaysViewModel(dataManager: DataManager,
                                      schedulerProvider: SchedulerProvider): ShowDaysViewModel {
        return ShowDaysViewModel(dataManager, schedulerProvider)
    }

    @Provides
    internal fun provideCitiesViewModel(dataManager: DataManager,
                                      schedulerProvider: SchedulerProvider): CitiesViewModel {
        return CitiesViewModel(dataManager, schedulerProvider)
    }

    @Provides
    internal fun provideSplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider,  locationProvider: LocationProvider): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider,locationProvider)
    }

}
