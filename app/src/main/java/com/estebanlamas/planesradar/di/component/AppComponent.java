package com.estebanlamas.planesradar.di.component;

import android.app.Application;

import com.estebanlamas.planesradar.di.module.AppModule;
import com.estebanlamas.planesradar.presentation.map.di.MapModule;
import com.estebanlamas.planesradar.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class}
)
public interface AppComponent {

    //Submodules
    MapComponent plus(MapModule module);

    //App general modules
    Application getApplication();
}
