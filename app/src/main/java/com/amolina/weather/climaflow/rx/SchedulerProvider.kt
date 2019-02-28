package com.amolina.weather.climaflow.rx

import io.reactivex.Scheduler

/**
 * Created by Amolina on 02/02/17.
 */

interface SchedulerProvider {

    fun ui(): Scheduler //observeOn

    fun computation(): Scheduler

    fun io(): Scheduler //subscribeOn

}
