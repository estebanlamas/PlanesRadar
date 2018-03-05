package com.estebanlamas.planesradar.domain

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread
import com.estebanlamas.planesradar.domain.model.AircraftsDetected
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import rx.Observable
import rx.Scheduler
import javax.inject.Inject

/**
 * Created by esteban on 26/12/17
 */

class GetAircraftsUseCase
@Inject constructor(threadExecutor: Scheduler,
            postExecutionThread: PostExecutionThread,
            private val aircraftRepository: AircraftRepository) : UseCase<AircraftsDetected>(threadExecutor,
                                                                                          postExecutionThread) {

    override fun buildObservable(): Observable<AircraftsDetected> = aircraftRepository.aircraftList
}
