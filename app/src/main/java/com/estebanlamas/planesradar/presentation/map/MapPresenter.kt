package com.estebanlamas.planesradar.presentation.map

import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import com.estebanlamas.planesradar.presentation.Presenter
import rx.Subscription
import java.util.*
import javax.inject.Inject

/**
 * Created by esteban on 24/9/17
 */

class MapPresenter
@Inject constructor(private val getAircraftsUseCase: GetAircraftsUseCase) : Presenter<MapView>() {
    private val refreshTimer = Timer()
    private var getAircraftsSubscription: Subscription? = null

    fun onResume() {
        initRadar()
    }

    private fun initRadar() {
        refreshTimer.schedule(object : TimerTask() {
            override fun run() {
                requestAircrafts()
            }
        }, 0, REFRESH_MILLISECONDS)
    }

    private fun requestAircrafts() {
        getAircraftsSubscription = getAircraftsUseCase.execute()
                .subscribe({ this.onAircraftReceived(it) }, { this.showErrorView(it) })
    }

    private fun onAircraftReceived(aircraftsDetected: AircraftsDetected) {
        view?.updateAircrafts(aircraftsDetected.aircrafts)
    }

    fun showErrorView(error: Throwable) {
        view?.showError(error.message)
    }

    fun onPause() {
        getAircraftsSubscription?.unsubscribe()
        refreshTimer.cancel()
    }

    companion object {
        const val REFRESH_MILLISECONDS = 3000L
    }
}
