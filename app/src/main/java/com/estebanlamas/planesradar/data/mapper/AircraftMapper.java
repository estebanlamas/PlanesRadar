package com.estebanlamas.planesradar.data.mapper;

import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse;
import com.estebanlamas.planesradar.data.remote.response.AircraftResponse;
import com.estebanlamas.planesradar.domain.model.Aircraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esteban on 20/11/17
 */

public class AircraftMapper {

    public static Aircraft mapResponse(AircraftResponse aircraftResponse){
        return new Aircraft(
                aircraftResponse.getAltitudGround(),
                aircraftResponse.getSerial(),
                aircraftResponse.getCallsign(),
                aircraftResponse.getAircraftCountry(),
                aircraftResponse.getEngineMount(),
                aircraftResponse.getEngineType(),
                aircraftResponse.getEnginesNum(),
                aircraftResponse.getFrom(),
                aircraftResponse.getAltitudeSeaLevel(),
                aircraftResponse.isOnGround(),
                aircraftResponse.isHelp(),
                aircraftResponse.getIdBroadcastIcao(),
                aircraftResponse.isInteresting(),
                aircraftResponse.getLatitude(),
                aircraftResponse.getLongitude(),
                aircraftResponse.getManufacturer(),
                aircraftResponse.getModelDescription(),
                aircraftResponse.isMilitary(),
                aircraftResponse.getOperator(),
                aircraftResponse.getOperatorIcao(),
                aircraftResponse.getPositionTime(),
                aircraftResponse.getRegistration(),
                aircraftResponse.getSpeed(),
                aircraftResponse.getAircraftType(),
                aircraftResponse.getSqwak(),
                aircraftResponse.getTo(),
                aircraftResponse.getHeading(),
                aircraftResponse.getModelIcao(),
                aircraftResponse.getVerticalSpeed(),
                aircraftResponse.getTurbulenceCategory(),
                aircraftResponse.getAge());
    }

    public static List<Aircraft> mapResponse(AircraftListResponse aircraftListResponse) {
        List<AircraftResponse> aircraftResponseList = aircraftListResponse.getAcList();
        List<Aircraft> aircraftList = new ArrayList<>();
        if(!aircraftResponseList.isEmpty()){
            for (AircraftResponse aircraftResponse : aircraftResponseList) {
                aircraftList.add(mapResponse(aircraftResponse));
            }
        }
        return aircraftList;
    }
}
