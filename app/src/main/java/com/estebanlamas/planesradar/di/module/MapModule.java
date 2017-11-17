package com.estebanlamas.planesradar.di.module;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.estebanlamas.planesradar.data.AircraftRepository;
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;
import com.estebanlamas.planesradar.presentation.map.MapViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MapModule {
    private FragmentActivity activity;

    public MapModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    FragmentActivity provideActivity(){
        return this.activity;
    }

    @Provides
    public MapViewModel provideMapViewModel(FragmentActivity fragmentActivity, AircraftRepository repository) {
        MapViewModel mapViewModel = ViewModelProviders.of(fragmentActivity).get(MapViewModel.class);
        mapViewModel.setRepository(repository);
        return mapViewModel;
    }

    @Provides
    public AircraftRepository provideAircraftRepository(AdsbExchangeApi adsbExchangeApi){
        return new AircraftRepository(adsbExchangeApi);
    }
}
