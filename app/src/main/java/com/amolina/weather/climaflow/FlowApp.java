package com.amolina.weather.climaflow;

import android.app.Activity;
import android.support.v4.app.Fragment;
import androidx.multidex.MultiDexApplication;
import com.amolina.weather.climaflow.di.component.DaggerAppComponent;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.facebook.stetho.Stetho;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import javax.inject.Inject;

/**
 * Created by Amolina on 02/02/17.
 */

public class FlowApp extends MultiDexApplication implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger 2 creates the DaggerComponent classes during compilation
        //see AppComponent
        Stetho.initializeWithDefaults(this);

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        //set style to text views like style="@style/TextStyle.Heading"
        //using fontPath with custom fonts (ttf)
        CalligraphyConfig.initDefault(mCalligraphyConfig);


        //instead of retrofit, implement http2, reduce latency, 50% faster
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
