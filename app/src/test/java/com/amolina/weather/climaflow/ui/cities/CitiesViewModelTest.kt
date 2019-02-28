package com.amolina.weather.climaflow.ui.cities

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.amolina.weather.climaflow.data.DataManager
import com.amolina.weather.climaflow.data.model.db.City
import com.amolina.weather.climaflow.data.model.db.Location
import com.amolina.weather.climaflow.rx.AppSchedulerProvider
import com.amolina.weather.climaflow.rx.SchedulerProvider
import com.amolina.weather.climaflow.ui.location.LocationProvider
import com.amolina.weather.climaflow.ui.splash.SplashViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doNothing





class CitiesViewModelTest{

    @Mock
    lateinit var dataManager: DataManager

    @Mock
    lateinit var scheduleProvider: SchedulerProvider

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val observer = mock(Observer::class.java) as Observer<List<CitiesItemModel>>



    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(dataManager.allCities).thenReturn(citiesList)

//        Mockito.`when`(scheduleProvider).thenReturn(AppSchedulerProvider())

        Mockito.`when`(scheduleProvider.io()).thenReturn(Schedulers.io())

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `loads more than one city`() {
        //Given



        val actionsSubject = PublishSubject.create<CitiesActions>()

        val citiesViewModel = mock(CitiesViewModel::class.java)

        //citiesViewModel = CitiesViewModel(dataManager,scheduleProvider)

        //`when`(citiesViewModel.getAllCities()).thenReturn(emptyList())
        citiesViewModel.showCities.observeForever(observer)

        doNothing().`when`(citiesViewModel).getSearchedCities("SALTA")

        //When
        //citiesViewModel.getSearchedCities("SALTA")

        //Then
        val uiModel = citiesViewModel.showCities
        assert(uiModel.value?.size != 0)
    }




    private val citiesList = Observable.just(
        listOf(
            City(
                id = 1, name = "city1", country = "AR",
                coord = Location(0, 0.0, 0.0), selected = 0, distance = 0f
            ),
            City(
                id = 2, name = "city2", country = "AR",
                coord = Location(1, 0.0, 0.0), selected = 0, distance = 0f
            ),
            City(
                id = 2, name = "city3", country = "AR",
                coord = Location(2, 0.0, 0.0), selected = 0, distance = 0f
            )
        )
    )


    private val citiesItemModelList = Observable.just(
        listOf(
            CitiesItemModel(
                id = 1, name = "city1"
            ),
            CitiesItemModel(
                id = 2, name = "city2"
            ),
            CitiesItemModel(
                id = 2, name = "city3"
            )
        )
    )
}