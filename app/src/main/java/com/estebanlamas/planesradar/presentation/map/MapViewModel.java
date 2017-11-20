package com.estebanlamas.planesradar.presentation.map;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.estebanlamas.planesradar.data.AircraftRepository;
import com.estebanlamas.planesradar.presentation.model.Aircraft;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by esteban on 24/9/17
 */

public class MapViewModel extends ViewModel {
    private static final int REFRESH_MILLISECONDS = 3000;
    private LiveData<List<Aircraft>> aircraftList;
    private Timer refreshTimer = new Timer();

    public MapViewModel(AircraftRepository repository) {
        if(aircraftList!=null) {
            return;
        }
        initRadar(repository);
    }

    LiveData<List<Aircraft>> getAircraftList() {
        return aircraftList;
    }

    private void initRadar(final AircraftRepository repository) {
        refreshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                requestAircrafts(repository);
            }
        },0,REFRESH_MILLISECONDS);
    }

    private void requestAircrafts(AircraftRepository repository) {
        aircraftList = repository.getAircraftList();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        refreshTimer.cancel();
    }
}
