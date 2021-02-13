package com.estebanlamas.planesradar.domain

import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import javax.inject.Inject

/**
 * Created by esteban on 26/12/17
 */

class GetAircraftsUseCase
@Inject constructor(
    private val aircraftRepository: AircraftRepository
) {
    fun execute() = aircraftRepository.aircraftList()
}
