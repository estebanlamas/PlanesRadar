package com.estebanlamas.planesradar.presentation.map;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.estebanlamas.planesradar.R;
import com.estebanlamas.planesradar.presentation.BaseActivity;
import com.estebanlamas.planesradar.presentation.map.di.MapModule;
import com.estebanlamas.planesradar.presentation.model.Aircraft;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

import javax.inject.Inject;

public class MapActivity extends BaseActivity implements OnMapReadyCallback, Observer<List<Aircraft>> {
    @Inject MapViewModel mapViewModel;
    @Inject AircraftMarker aircraftMarker;

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    /*********************
     * OnMapReadyCallback
     ********************/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.mapViewModel.getAircraftList().observe(this, this);
    }

    /************
     * Observer
     ***********/

    @Override
    public void onChanged(@Nullable List<Aircraft> aircraftList) {
        if(googleMap!=null && aircraftList!=null) {
            googleMap.clear();
            for (Aircraft aircraft : aircraftList) {
                googleMap.addMarker(aircraftMarker.create(aircraft));
            }
        }
    }
}
