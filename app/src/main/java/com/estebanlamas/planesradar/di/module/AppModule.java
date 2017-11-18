package com.estebanlamas.planesradar.di.module;

import android.app.Application;

import com.estebanlamas.planesradar.presentation.BitmapUtils;
import com.estebanlamas.planesradar.presentation.map.AircraftMarker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    BitmapUtils providesBitmapUtils(Application application) {
        return new BitmapUtils(application);
    }

    @Provides
    @Singleton
    AircraftMarker providesAircraftMarker(BitmapUtils bitmapUtils) {
        return new AircraftMarker(bitmapUtils);
    }
}
