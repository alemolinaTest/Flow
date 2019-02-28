package com.amolina.weather.climaflow.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean

import com.amolina.weather.climaflow.data.DataManager
import com.amolina.weather.climaflow.rx.SchedulerProvider

import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Amolina on 02/02/17.
 */

abstract class BaseViewModel<N>(val dataManager: DataManager,
                                val schedulerProvider: SchedulerProvider) : ViewModel() {

    var navigator: N? = null
    val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onViewCreated() {

    }

    fun onDestroyView() {

    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
