package com.estebanlamas.planesradar.data

import com.estebanlamas.planesradar.data.mapper.AircraftMapper
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by esteban on 26/12/17
 */

class AircraftDataRepository
@Inject constructor(
    adsbExchangeApi: AdsbExchangeApi
) : BaseRepository(adsbExchangeApi), AircraftRepository {

    companion object {
        const val REFRESH_MILLISECONDS = 3000L
    }

    override fun aircraftList(): Flow<AircraftsDetected> = flow {
        while(true) {
            emit(AircraftMapper.mapResponse(adsbExchangeApi.aircraftList()))
            delay(REFRESH_MILLISECONDS)
        }
    }
}
