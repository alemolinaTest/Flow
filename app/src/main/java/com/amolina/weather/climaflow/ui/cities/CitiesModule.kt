package com.amolina.weather.climaflow.ui.cities

import com.amolina.weather.climaflow.data.DataManager
import com.amolina.weather.climaflow.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Amolina on 02/02/17.
 */
@Module
class CitiesModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager,
                                      schedulerProvider: SchedulerProvider): CitiesViewModel {
        return CitiesViewModel(dataManager, schedulerProvider)
    }

}
