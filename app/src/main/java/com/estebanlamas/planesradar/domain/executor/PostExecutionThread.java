package com.estebanlamas.planesradar.domain.executor;

import rx.Scheduler;

/**
 * Created by esteban on 3/1/18
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
