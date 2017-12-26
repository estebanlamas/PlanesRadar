package com.estebanlamas.planesradar.domain.repository;

import com.estebanlamas.planesradar.domain.model.Aircraft;

import java.util.List;

import rx.Observable;

/**
 * Created by esteban on 26/12/17
 */

public interface AircraftRepository {
    Observable<List<Aircraft>> getAircraftList();
}
