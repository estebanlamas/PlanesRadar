package com.estebanlamas.planesradar.domain.repository

import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import kotlinx.coroutines.flow.Flow

interface AircraftRepository {
    fun aircraftList(): Flow<AircraftsDetected>
}
