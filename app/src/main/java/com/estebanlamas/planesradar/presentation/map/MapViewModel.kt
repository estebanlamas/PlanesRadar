package com.estebanlamas.planesradar.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import com.estebanlamas.planesradar.domain.model.Aircraft
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by esteban on 24/9/17
 */

class MapViewModel
@Inject constructor(getAircraftsUseCase: GetAircraftsUseCase): ViewModel() {
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error
    val aircraftList: LiveData<List<Aircraft>> = getAircraftsUseCase.execute()
        .catch { _error.postValue(it.message) }
        .map { it.aircrafts }
        .asLiveData()
}
