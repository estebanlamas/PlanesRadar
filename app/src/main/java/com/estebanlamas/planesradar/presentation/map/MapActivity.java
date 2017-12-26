package com.estebanlamas.planesradar.presentation.map;

import android.os.Bundle;

import com.estebanlamas.planesradar.R;
import com.estebanlamas.planesradar.domain.model.Aircraft;
import com.estebanlamas.planesradar.presentation.BaseActivity;
import com.estebanlamas.planesradar.presentation.map.di.MapModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

import javax.inject.Inject;

public class MapActivity extends BaseActivity implements OnMapReadyCallback, MapView{
    @Inject MapPresenter mapPresenter;
    @Inject AircraftMarker aircraftMarker;

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapPresenter.attachView(this);
        setupMapFragment();
    }

    private void setupMapFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void setModule() {
        getApplicationComponent().plus(new MapModule(this)).inject(this);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_maps;
    }

    @Override
    public void onPause() {
        mapPresenter.onPause();
        super.onPause();
    }

    /*********************
     * OnMapReadyCallback
     ********************/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.mapPresenter.onResume();
    }

    /************
     * MapView
     ***********/

    @Override
    public void updateAircrafts(List<Aircraft> aircraftList) {
        if(googleMap!=null && aircraftList!=null) {
            googleMap.clear();
            for (Aircraft aircraft : aircraftList) {
                googleMap.addMarker(aircraftMarker.create(aircraft));
            }
        }
    }
}
