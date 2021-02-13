package com.estebanlamas.planesradar.presentation.map

import android.os.Bundle
import android.widget.Toast

import com.estebanlamas.planesradar.R
import com.estebanlamas.planesradar.presentation.BaseActivity
import com.estebanlamas.planesradar.presentation.map.di.MapModule
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class MapActivity : BaseActivity(), OnMapReadyCallback {

    @Inject
    lateinit var mapViewModel: MapViewModel

    @Inject
    lateinit var aircraftMarker: AircraftMarker

    private var googleMap: GoogleMap? = null

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
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

    override fun onDestroy() {
        super.onDestroy()
        mapViewModel.stopRadar()
    }

    // region Google Map

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.animateCamera(zoomCamera())
        observeAircrafts()
        observeError()
        mapViewModel.initRadar()
    }

    private fun zoomCamera(): CameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(CENTER_LAT, CENTER_LON), DEFAULT_ZOOM)

    private fun observeAircrafts() {
        mapViewModel.aircraftList.observe(this) {
            googleMap?.clear()
            for (aircraft in it) {
                googleMap?.addMarker(aircraftMarker.create(aircraft))
            }
        }
    }

    private fun observeError() {
        mapViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    // endregion

    companion object {
        private const val CENTER_LAT = 40.4322308
        private const val CENTER_LON = -3.674026
        private const val DEFAULT_ZOOM = 9.0f
    }
}
