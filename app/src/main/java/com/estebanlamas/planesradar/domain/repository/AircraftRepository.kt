package com.estebanlamas.planesradar.domain.repository

import com.estebanlamas.planesradar.domain.model.Aircraft

import rx.Observable

/**
 * Created by esteban on 26/12/17
 */

interface AircraftRepository {
    val aircraftList: Observable<List<Aircraft>>
}
