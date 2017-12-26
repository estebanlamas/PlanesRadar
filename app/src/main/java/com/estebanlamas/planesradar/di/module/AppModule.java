package com.estebanlamas.planesradar.di.module;

import android.app.Application;

import com.estebanlamas.planesradar.presentation.utils.BitmapUtils;
import com.estebanlamas.planesradar.presentation.map.AircraftMarker;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @Provides @Named("executor")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }

    @Provides @Named("ui")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
