package com.amolina.weather.climaflow.ui.show

import com.amolina.weather.climaflow.ui.cities.CitiesFragment
import com.amolina.weather.climaflow.ui.cities.CitiesFragmentModule
import com.amolina.weather.climaflow.ui.showDays.ShowDaysFragment
import com.amolina.weather.climaflow.ui.showDays.ShowFragmentDaysModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amolina on 02/02/17.
 */
@Module
abstract class ShowFragmentProvider {

    @ContributesAndroidInjector(modules = [ShowFragmentModule::class])
    internal abstract fun provideShowFragmentFactory(): ShowFragment

    @ContributesAndroidInjector(modules = [ShowFragmentDaysModule::class])
    internal abstract fun provideShowDaysFragmentFactory(): ShowDaysFragment

    @ContributesAndroidInjector(modules = [CitiesFragmentModule::class])
    internal abstract fun provideCitiesFragmentFactory(): CitiesFragment

}
