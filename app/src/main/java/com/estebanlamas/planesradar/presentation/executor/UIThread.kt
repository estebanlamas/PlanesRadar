package com.estebanlamas.planesradar.presentation.executor

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread

import javax.inject.Inject

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by esteban on 3/1/18
 */

class UIThread @Inject
constructor() : PostExecutionThread {
    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}
