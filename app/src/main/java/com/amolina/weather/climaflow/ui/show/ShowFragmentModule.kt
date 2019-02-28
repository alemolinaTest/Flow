package com.amolina.weather.climaflow.ui.show

import android.support.v7.widget.LinearLayoutManager
import com.amolina.weather.climaflow.ui.cities.CitiesAdapter

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Amolina on 02/02/17.
 */
@Module
class ShowFragmentModule {

    @Provides
    @Singleton
    internal fun provideShowAdapter(): ShowAdapter {
        return ShowAdapter()
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: ShowFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

}
