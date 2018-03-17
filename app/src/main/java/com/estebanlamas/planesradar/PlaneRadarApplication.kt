package com.estebanlamas.planesradar

import android.app.Application

import com.estebanlamas.planesradar.di.component.AppComponent
import com.estebanlamas.planesradar.di.component.DaggerAppComponent
import com.estebanlamas.planesradar.di.module.AppModule

/**
 * Created by esteban on 24/9/17
 */

class PlaneRadarApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeDependecyInjector()
    }

    private fun initializeDependecyInjector() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
