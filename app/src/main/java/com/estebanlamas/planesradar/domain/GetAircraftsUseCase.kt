package com.estebanlamas.planesradar.domain

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread
import com.estebanlamas.planesradar.domain.repository.AircraftRepository
import com.estebanlamas.planesradar.domain.model.Aircraft

import javax.inject.Inject

import rx.Observable
import rx.Scheduler

/**
 * Created by esteban on 26/12/17
 */

//class GetAircraftsUseCase
//@Inject constructor(threadExecutor: Scheduler,
//            postExecutionThread: PostExecutionThread,
//            private val aircraftRepository: AircraftRepository) : UseCase<List<Aircraft>>(threadExecutor,
//                                                                                          postExecutionThread) {
//
//    override fun buildObservable(): Observable<List<Aircraft>> =  aircraftRepository.aircraftList
//}
class GetAircraftsUseCase
@Inject constructor(val threadExecutor: Scheduler,
                    val postExecutionThread: PostExecutionThread,
                    private val aircraftRepository: AircraftRepository){

    fun buildObservable(): Observable<List<Aircraft>> {
        return aircraftRepository.aircraftList
                .observeOn(postExecutionThread.scheduler)
                .subscribeOn(threadExecutor)
    }
}
