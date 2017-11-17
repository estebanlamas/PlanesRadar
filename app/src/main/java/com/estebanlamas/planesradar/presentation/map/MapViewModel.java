package com.estebanlamas.planesradar.presentation.map;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.estebanlamas.planesradar.data.AircraftRepository;
import com.estebanlamas.planesradar.data.remote.model.AircraftResponse;

import java.util.List;

/**
 * Created by esteban on 24/9/17
 */

public class MapViewModel extends AndroidViewModel{
    private LiveData<List<AircraftResponse>> aircraftList;
    private AircraftRepository repository;

    public MapViewModel(Application application) {
        super(application);
    }

    public void setRepository(AircraftRepository repository) {
        this.repository = repository;
    }

    public void init() {
        if(aircraftList!=null) {
            return;
        }
        aircraftList = repository.getAircraftList();
    }

    public LiveData<List<AircraftResponse>> getAircraftList() {
        return aircraftList;
    }
}
