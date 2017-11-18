package com.estebanlamas.planesradar.presentation.map;

import com.estebanlamas.planesradar.R;
import com.estebanlamas.planesradar.data.remote.model.AircraftResponse;
import com.estebanlamas.planesradar.presentation.utils.BitmapUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by esteban on 18/11/17
 */

public class AircraftMarker {
    private BitmapUtils bitmapUtils;

    public AircraftMarker(BitmapUtils bitmapUtils) {
        this.bitmapUtils = bitmapUtils;
    }

    public MarkerOptions create(AircraftResponse aircraftResponse) {
        LatLng latLon = new LatLng(aircraftResponse.getLatitude(),aircraftResponse.getLongitude());
        return new MarkerOptions()
                .position(latLon)
                .title(aircraftResponse.getCallsign())
                .rotation(aircraftResponse.getHeading())
                .icon(bitmapUtils.getBitmapDescriptorFromVector(R.drawable.ic_a320))
                .anchor(0.5f,0.5f);
    }


}
