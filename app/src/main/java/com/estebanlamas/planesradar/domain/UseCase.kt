package com.estebanlamas.planesradar.domain

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread

import rx.Observable
import rx.Scheduler

/**
 * Created by esteban on 26/12/17
 */

abstract class UseCase<T>(
        private val threadExecutor: Scheduler,
        private val mainThread: PostExecutionThread) {

    abstract fun buildObservable(): Observable<T>

    fun execute(): Observable<T> {
        return buildObservable()
                .observeOn(mainThread.scheduler)
                .subscribeOn(threadExecutor)
    }
}
