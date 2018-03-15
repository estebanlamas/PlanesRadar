package com.estebanlamas.planesradar.data

import com.estebanlamas.planesradar.data.mapper.AircraftMapper
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by esteban on 26/12/17
 */

class AircraftDataRepository
@Inject constructor(adsbExchangeApi: AdsbExchangeApi) : BaseRepository(adsbExchangeApi), AircraftRepository {

    override val aircraftList: Observable<AircraftsDetected> = adsbExchangeApi.aircraftList.flatMap {
        aircraftListResponse -> Observable.just(AircraftMapper.mapResponse(aircraftListResponse))
    }
}
