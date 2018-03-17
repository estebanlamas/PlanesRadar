package com.estebanlamas.planesradar.presentation.map

import com.estebanlamas.planesradar.domain.model.Aircraft

/**
 * Created by esteban on 26/12/17
 */

interface MapView {
    fun updateAircrafts(aircraftList: List<Aircraft>)
    fun showError(message: String?)
}
