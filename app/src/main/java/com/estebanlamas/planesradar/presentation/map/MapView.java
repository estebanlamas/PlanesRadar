package com.estebanlamas.planesradar.presentation.map;

import com.estebanlamas.planesradar.domain.model.Aircraft;

import java.util.List;

/**
 * Created by esteban on 26/12/17
 */

public interface MapView {
    void updateAircrafts(List<Aircraft> aircraftList);
    void showError(String message);
}
