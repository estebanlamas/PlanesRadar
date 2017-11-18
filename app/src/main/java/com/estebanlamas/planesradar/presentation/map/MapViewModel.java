package com.estebanlamas.planesradar.presentation.map;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.estebanlamas.planesradar.data.AircraftRepository;
import com.estebanlamas.planesradar.data.remote.model.AircraftResponse;

import java.util.List;

/**
 * Created by esteban on 24/9/17
 */

public class MapViewModel extends ViewModel {
    private LiveData<List<AircraftResponse>> aircraftList;

    public MapViewModel(AircraftRepository repository) {
        if(aircraftList!=null) {
            return;
        }
        aircraftList = repository.getAircraftList();
    }

    public LiveData<List<AircraftResponse>> getAircraftList() {
        return aircraftList;
    }
}
