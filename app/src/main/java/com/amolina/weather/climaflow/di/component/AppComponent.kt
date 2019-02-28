package com.amolina.weather.climaflow.di.component

import android.app.Application

import com.amolina.weather.climaflow.FlowApp
import com.amolina.weather.climaflow.di.builder.ActivityBuilder
import com.amolina.weather.climaflow.di.module.AppModule
import com.amolina.weather.climaflow.di.module.LocationModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by Amolina on 02/02/17.
 */

// Component is a graph. We build a component. Component will provide injected instances by using modules
//AppModule get application Context, provideAppDatabase builds the database, provideDbHelper,providePreferencesHelper, provideApiHelper
//AndroidInjectionModule -Provides our activities and fragments with given module
//ActivityBuilder - We map all our activities here
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, LocationModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: FlowApp)

}
