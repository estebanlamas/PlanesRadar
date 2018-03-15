package com.estebanlamas.planesradar.data.mapper

import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse
import com.estebanlamas.planesradar.data.remote.response.AircraftResponse
import com.estebanlamas.planesradar.domain.model.Aircraft
import com.estebanlamas.planesradar.domain.model.AircraftsDetected

import java.util.ArrayList

/**
 * Created by esteban on 20/11/17
 */

object AircraftMapper {

    fun mapResponse(aircraftResponse: AircraftResponse): Aircraft {
        return Aircraft(
                aircraftResponse.altitudGround,
                aircraftResponse.serial,
                aircraftResponse.callsign,
                aircraftResponse.aircraftCountry,
                aircraftResponse.engineMount,
                aircraftResponse.engineType,
                aircraftResponse.enginesNum,
                aircraftResponse.from,
                aircraftResponse.altitudeSeaLevel,
                aircraftResponse.isOnGround,
                aircraftResponse.isHelp,
                aircraftResponse.idBroadcastIcao,
                aircraftResponse.isInteresting,
                aircraftResponse.latitude,
                aircraftResponse.longitude,
                aircraftResponse.manufacturer,
                aircraftResponse.modelDescription,
                aircraftResponse.isMilitary,
                aircraftResponse.operator,
                aircraftResponse.operatorIcao,
                aircraftResponse.positionTime,
                aircraftResponse.registration,
                aircraftResponse.speed,
                aircraftResponse.aircraftType,
                aircraftResponse.sqwak,
                aircraftResponse.to,
                aircraftResponse.heading,
                aircraftResponse.modelIcao,
                aircraftResponse.verticalSpeed,
                aircraftResponse.turbulenceCategory,
                aircraftResponse.age)
    }

    fun mapResponse(aircraftListResponse: AircraftListResponse): AircraftsDetected {
        val aircraftList = ArrayList<Aircraft>()
        for (aircraftResponse in aircraftListResponse.acList) {
            aircraftList.add(mapResponse(aircraftResponse))
        }
        return AircraftsDetected(aircraftList)
    }
}
