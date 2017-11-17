package com.estebanlamas.planesradar.presentation.map;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.estebanlamas.planesradar.R;
import com.estebanlamas.planesradar.data.remote.model.AircraftResponse;
import com.estebanlamas.planesradar.di.module.MapModule;
import com.estebanlamas.planesradar.presentation.BaseActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

public class MapActivity extends BaseActivity implements OnMapReadyCallback {
    @Inject
    MapViewModel mapViewModel;

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        mapViewModel.init();
        mapViewModel.getAircraftList().observe(this, new Observer<List<AircraftResponse>>() {
            @Override
            public void onChanged(@Nullable List<AircraftResponse> aircraftResponses) {
                for (AircraftResponse aircraftResponse : aircraftResponses) {
                    LatLng latLon = new LatLng(aircraftResponse.getLat(),aircraftResponse.getLong());
                    MapActivity.this.googleMap.addMarker(new MarkerOptions().position(latLon).title(aircraftResponse.getType()));
                }
            }
        });
    }
}
