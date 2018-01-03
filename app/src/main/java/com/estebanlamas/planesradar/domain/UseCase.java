package com.estebanlamas.planesradar.domain;

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by esteban on 26/12/17
 */

public abstract class UseCase<T> {
    private final Scheduler threadExecutor;
    private final PostExecutionThread mainThread;

    public UseCase(Scheduler threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.mainThread = postExecutionThread;
    }

    public abstract Observable<T> buildObservable();

    public Observable<T> execute() {
        return buildObservable()
                .observeOn(mainThread.getScheduler())
                .subscribeOn(threadExecutor);
    }
}
