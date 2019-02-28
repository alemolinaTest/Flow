package com.amolina.weather.climaflow.ui.cities

import android.support.v7.widget.LinearLayoutManager
import com.amolina.weather.climaflow.ui.cities.CitiesAdapter

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Amolina on 02/02/17.
 */
@Module
class CitiesFragmentModule {

    @Provides
    internal fun provideLinearLayoutManager(fragment: CitiesFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    @Singleton
    internal fun provideCitiesAdapter(): CitiesAdapter {
        return CitiesAdapter()
    }

}
