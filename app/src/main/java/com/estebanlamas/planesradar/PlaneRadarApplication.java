package com.estebanlamas.planesradar;

import android.app.Application;

import com.estebanlamas.planesradar.di.component.AppComponent;
import com.estebanlamas.planesradar.di.component.DaggerAppComponent;
import com.estebanlamas.planesradar.di.module.AppModule;
import com.estebanlamas.planesradar.di.module.NetworkModule;

/**
 * Created by esteban on 24/9/17
 */

public class PlaneRadarApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependecyInjector();
    }

    private void initializeDependecyInjector() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
