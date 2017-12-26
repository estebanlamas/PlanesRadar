package com.estebanlamas.planesradar.presentation.map;

import com.estebanlamas.planesradar.domain.GetAircraftsUseCase;
import com.estebanlamas.planesradar.domain.model.Aircraft;
import com.estebanlamas.planesradar.presentation.Presenter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by esteban on 24/9/17
 */

public class MapPresenter extends Presenter<MapView> {
    private static final int REFRESH_MILLISECONDS = 3000;
    private Timer refreshTimer = new Timer();
    private GetAircraftsUseCase getAircraftsUseCase;
    private Subscription getAircraftsSubscription;

    @Inject
    public MapPresenter(GetAircraftsUseCase getAircraftsUseCase) {
        this.getAircraftsUseCase = getAircraftsUseCase;
    }

    public void onResume() {
        initRadar();
    }

    private void initRadar() {
        refreshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                requestAircrafts();
            }
        }, 0, REFRESH_MILLISECONDS);
    }

    private void requestAircrafts() {
        getAircraftsSubscription = getAircraftsUseCase.execute()
                .subscribe(this::onAircraftReceived, this::showErrorView);
    }

    private void onAircraftReceived(List<Aircraft> aircraftList){
        view.updateAircrafts(aircraftList);
    }

    public void showErrorView(Throwable error) {

    }

    public void onPause() {
        getAircraftsSubscription.unsubscribe();
        refreshTimer.cancel();
    }
}
