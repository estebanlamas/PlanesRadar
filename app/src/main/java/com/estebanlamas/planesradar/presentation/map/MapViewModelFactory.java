package com.estebanlamas.planesradar.presentation.map;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.estebanlamas.planesradar.data.AircraftRepository;

/**
 * Created by esteban on 18/11/17
 */
public class MapViewModelFactory implements ViewModelProvider.Factory {
    private AircraftRepository aircraftRepository;

    public MapViewModelFactory(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MapViewModel.class)) {
            return (T) new MapViewModel(aircraftRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
