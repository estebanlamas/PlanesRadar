package com.estebanlamas.planesradar.presentation.map.di

import android.support.v4.app.FragmentActivity

import com.estebanlamas.planesradar.data.AircraftDataRepository
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import com.estebanlamas.planesradar.presentation.map.MapPresenter

import dagger.Module
import dagger.Provides

@Module
class MapModule(private val activity: FragmentActivity) {

    @Provides
    fun provideActivity(): FragmentActivity {
        return this.activity
    }

    @Provides
    fun provideMapPresenter(getAircraftsUseCase: GetAircraftsUseCase): MapPresenter {
        return MapPresenter(getAircraftsUseCase)
    }

    @Provides
    fun provideAircraftRepository(aircraftDataRepository: AircraftDataRepository): AircraftRepository {
        return aircraftDataRepository
    }

}
