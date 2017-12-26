package com.estebanlamas.planesradar.domain;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by esteban on 26/12/17
 */

public abstract class UseCase<T> {
    protected final Scheduler uiThread;
    protected final Scheduler executorThread;

    public UseCase(Scheduler uiThread, Scheduler executorThread) {
        this.uiThread = uiThread;
        this.executorThread = executorThread;
    }

    public abstract Observable<T> buildObservable();
    public Observable<T> execute() {
        return buildObservable();
    }
}
