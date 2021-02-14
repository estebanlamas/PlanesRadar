package com.estebanlamas.planesradar.presentation.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by esteban on 24/9/17
 */
class MapViewModel
@Inject constructor(getAircraftsUseCase: GetAircraftsUseCase): ViewModel() {
    val error = MutableLiveData<String>()
    val aircraftList = getAircraftsUseCase.execute()
        .catch { error.postValue(it.message) }
        .map { it.aircrafts }
        .asLiveData()
}
