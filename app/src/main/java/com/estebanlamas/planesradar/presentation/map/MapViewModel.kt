package com.estebanlamas.planesradar.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import com.estebanlamas.planesradar.domain.model.Aircraft
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by esteban on 24/9/17
 */

class MapViewModel
@Inject constructor(private val getAircraftsUseCase: GetAircraftsUseCase): ViewModel() {
    private var isActive = true
    private val _aircraftList = MutableLiveData<List<Aircraft>>()
    val aircraftList: LiveData<List<Aircraft>> = _aircraftList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun initRadar() {
        viewModelScope.launch {
            while (isActive) {
                getAircraftsUseCase.execute()
                    .catch { _error.postValue(it.message) }
                    .collect {
                        _aircraftList.postValue(it.aircrafts)
                    }
                delay(REFRESH_MILLISECONDS)
            }
        }
    }

    fun stopRadar() {
        isActive = false
    }

    companion object {
        const val REFRESH_MILLISECONDS = 3000L
    }
}
