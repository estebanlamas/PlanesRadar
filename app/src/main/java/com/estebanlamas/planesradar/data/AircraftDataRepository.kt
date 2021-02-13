package com.estebanlamas.planesradar.data

import com.estebanlamas.planesradar.data.mapper.AircraftMapper
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
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

    override fun aircraftList(): Flow<AircraftsDetected> = flow {
        emit(AircraftMapper.mapResponse(adsbExchangeApi.aircraftList()))
    }
}
