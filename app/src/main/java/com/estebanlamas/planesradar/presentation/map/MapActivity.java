package com.estebanlamas.planesradar.presentation.map;

import android.os.Bundle;
import android.widget.Toast;

import com.estebanlamas.planesradar.R;
import com.estebanlamas.planesradar.domain.model.Aircraft;
import com.estebanlamas.planesradar.presentation.BaseActivity;
import com.estebanlamas.planesradar.presentation.map.di.MapModule;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import javax.inject.Inject;

public class MapActivity extends BaseActivity implements OnMapReadyCallback, MapView {
    private final static double CENTER_LAT = 40.4322308;
    private final static double CENTER_LON = -3.674026;
    private final static float DEFAULT_ZOOM = 9.0f;

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
        this.googleMap.animateCamera(getCameraUpdate());
    }

    private CameraUpdate getCameraUpdate() {
        return CameraUpdateFactory.newLatLngZoom(new LatLng(CENTER_LAT, CENTER_LON), DEFAULT_ZOOM);
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

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
