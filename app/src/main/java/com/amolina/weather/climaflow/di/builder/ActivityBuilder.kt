package com.amolina.weather.climaflow.di.builder


import com.amolina.weather.climaflow.ui.cities.CitiesActivity
import com.amolina.weather.climaflow.ui.cities.CitiesFragmentProvider
import com.amolina.weather.climaflow.ui.cities.CitiesModule
import com.amolina.weather.climaflow.ui.main.MainActivity
import com.amolina.weather.climaflow.ui.main.MainActivityModule
import com.amolina.weather.climaflow.ui.show.ShowFragmentProvider
import com.amolina.weather.climaflow.ui.splash.SplashActivity
import com.amolina.weather.climaflow.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amolina on 14/09/17.
 */

// We map all our activities here, with their modules, that provides the correspondent ViewModel
@Module
abstract class ActivityBuilder {
    /* UI subcomponents(SplashActivityComponent , LoginActivityComponent, MainActivityComponent)
    are just like bridges to get the modules in the graph, those modules provide the ViewModel class
    With this annotation, we can easily attach activities/fragments to dagger graph
    without using components for every activity*/

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class, ShowFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [CitiesModule::class, CitiesFragmentProvider::class])
    internal abstract fun bindCitiesActivity(): CitiesActivity

}
