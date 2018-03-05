package com.estebanlamas.planesradar.data;

import com.estebanlamas.planesradar.data.mapper.AircraftMapper;
import com.estebanlamas.planesradar.data.remote.AdsbExchangeApi;
import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse;
import com.estebanlamas.planesradar.domain.model.AircraftsDetected;
import com.estebanlamas.planesradar.domain.repository.AircraftRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by esteban on 26/12/17
 */

public class AircraftDataRepository extends BaseRepository implements AircraftRepository{

    @Inject
    public AircraftDataRepository(AdsbExchangeApi adsbExchangeApi) {
        super(adsbExchangeApi);
    }

    public Observable<AircraftsDetected> getAircraftList() {
        return adsbExchangeApi.getAircraftList().flatMap(new Func1<AircraftListResponse, Observable<AircraftsDetected>>() {
            @Override
            public Observable<AircraftsDetected> call(AircraftListResponse aircraftListResponse) {
                return Observable.just(AircraftMapper.mapResponse(aircraftListResponse));
            }
        });
    }
}
