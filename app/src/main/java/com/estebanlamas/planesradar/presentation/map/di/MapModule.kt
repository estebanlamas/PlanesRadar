package com.estebanlamas.planesradar.presentation.map.di

import androidx.fragment.app.FragmentActivity

import com.estebanlamas.planesradar.data.AircraftDataRepository
import com.estebanlamas.planesradar.domain.GetAircraftsUseCase
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import com.estebanlamas.planesradar.presentation.map.MapViewModel

import dagger.Module
import dagger.Provides

@Module
class MapModule(private val activity: FragmentActivity) {

    @Provides
    fun provideActivity(): FragmentActivity {
        return this.activity
    }

    @Provides
    fun provideMapPresenter(getAircraftsUseCase: GetAircraftsUseCase): MapViewModel {
        return MapViewModel(getAircraftsUseCase)
    }

    @Provides
    fun provideAircraftRepository(aircraftDataRepository: AircraftDataRepository): AircraftRepository {
        return aircraftDataRepository
    }

}
