package com.estebanlamas.planesradar.presentation.map.di;

import android.support.v4.app.FragmentActivity;

import com.estebanlamas.planesradar.data.AircraftDataRepository;
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase;
import com.estebanlamas.planesradar.domain.repository.AircraftRepository;
import com.estebanlamas.planesradar.presentation.map.MapPresenter;

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
    public MapPresenter provideMapPresenter(GetAircraftsUseCase getAircraftsUseCase) {
        return new MapPresenter(getAircraftsUseCase);
    }

    @Provides
    public AircraftRepository provideAircraftRepository(AircraftDataRepository aircraftDataRepository) {
        return aircraftDataRepository;
    }

}
