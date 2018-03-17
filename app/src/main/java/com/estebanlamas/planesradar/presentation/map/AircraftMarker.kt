package com.estebanlamas.planesradar.presentation.map

import com.estebanlamas.planesradar.R
import com.estebanlamas.planesradar.domain.model.Aircraft
import com.estebanlamas.planesradar.presentation.utils.BitmapUtils
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by esteban on 18/11/17
 */

class AircraftMarker(private val bitmapUtils: BitmapUtils) {

    fun create(aircraft: Aircraft): MarkerOptions {
        val latLon = LatLng(aircraft.latitude, aircraft.longitude)
        return MarkerOptions()
                .position(latLon)
                .title(aircraft.callsign)
                .rotation(aircraft.heading)
                .icon(bitmapUtils.getBitmapDescriptorFromVector(R.drawable.ic_a320))
                .anchor(0.5f, 0.5f)
    }
}
