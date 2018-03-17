package com.estebanlamas.planesradar.presentation.map

import android.os.Bundle
import android.widget.Toast

import com.estebanlamas.planesradar.R
import com.estebanlamas.planesradar.domain.model.Aircraft
import com.estebanlamas.planesradar.presentation.BaseActivity
import com.estebanlamas.planesradar.presentation.map.di.MapModule
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

import javax.inject.Inject

class MapActivity : BaseActivity(), OnMapReadyCallback, MapView {

    @Inject
    lateinit var mapPresenter: MapPresenter

    @Inject
    lateinit var aircraftMarker: AircraftMarker

    private var googleMap: GoogleMap? = null

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        mapPresenter.attachView(this)
        setupMapFragment()
    }

    private fun setupMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun setModule() {
        applicationComponent.plus(MapModule(this)).inject(this)
    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_maps
    }

    public override fun onPause() {
        mapPresenter.onPause()
        super.onPause()
    }

    /*********************
     * OnMapReadyCallback
     ********************/

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        this.mapPresenter.onResume()
        googleMap.animateCamera(zoomCammera())
    }

    private fun zoomCammera(): CameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(CENTER_LAT, CENTER_LON), DEFAULT_ZOOM)

    /************
     * MapView
     ***********/

    override fun updateAircrafts(aircraftList: List<Aircraft>) {
        googleMap?.clear()
        for (aircraft in aircraftList) {
            googleMap?.addMarker(aircraftMarker.create(aircraft))
        }
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val CENTER_LAT = 40.4322308
        private const val CENTER_LON = -3.674026
        private const val DEFAULT_ZOOM = 9.0f
    }
}
