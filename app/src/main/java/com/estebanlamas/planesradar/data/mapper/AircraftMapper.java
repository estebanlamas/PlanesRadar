package com.estebanlamas.planesradar.data.mapper;

import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse;
import com.estebanlamas.planesradar.data.remote.response.AircraftResponse;
import com.estebanlamas.planesradar.presentation.model.Aircraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esteban on 20/11/17
 */

public class AircraftMapper {

    public static Aircraft mapResponse(AircraftResponse aircraftResponse){
        Aircraft aircraft = new Aircraft();
        aircraft.setAge(aircraftResponse.getAge());
        aircraft.setAircraftCountry(aircraftResponse.getAircraftCountry());
        aircraft.setAltitudeSeaLevel(aircraftResponse.getAltitudeSeaLevel());
        aircraft.setAircraftType(aircraftResponse.getAircraftType());
        aircraft.setAltitudGround(aircraftResponse.getAltitudGround());
        aircraft.setCallsign(aircraftResponse.getCallsign());
        aircraft.setEngineMount(aircraftResponse.getEngineMount());
        aircraft.setEnginesNum(aircraftResponse.getEnginesNum());
        aircraft.setEngineType(aircraftResponse.getEngineType());
        aircraft.setFrom(aircraftResponse.getFrom());
        aircraft.setTo(aircraftResponse.getTo());
        aircraft.setHeading(aircraftResponse.getHeading());
        aircraft.setHelp(aircraftResponse.isHelp());
        aircraft.setIdBroadcastIcao(aircraftResponse.getIdBroadcastIcao());
        aircraft.setInteresting(aircraftResponse.isInteresting());
        aircraft.setLatitude(aircraftResponse.getLatitude());
        aircraft.setLongitude(aircraftResponse.getLongitude());
        aircraft.setManufacturer(aircraftResponse.getManufacturer());
        aircraft.setMilitary(aircraftResponse.isMilitary());
        aircraft.setModelDescription(aircraftResponse.getModelDescription());
        aircraft.setModelIcao(aircraftResponse.getModelIcao());
        aircraft.setOnGround(aircraftResponse.isOnGround());
        aircraft.setOperator(aircraftResponse.getOperator());
        aircraft.setOperatorIcao(aircraftResponse.getOperatorIcao());
        aircraft.setPositionTime(aircraftResponse.getPositionTime());
        aircraft.setRegistration(aircraftResponse.getRegistration());
        aircraft.setSerial(aircraftResponse.getSerial());
        aircraft.setSpeed(aircraftResponse.getSpeed());
        aircraft.setSqwak(aircraftResponse.getSqwak());
        aircraft.setTurbulenceCategory(aircraftResponse.getTurbulenceCategory());
        aircraft.setVerticalSpeed(aircraftResponse.getVerticalSpeed());
        return aircraft;
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
