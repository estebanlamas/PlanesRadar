package com.estebanlamas.planesradar.domain;

import com.estebanlamas.planesradar.domain.executor.PostExecutionThread;
import com.estebanlamas.planesradar.domain.repository.AircraftRepository;
import com.estebanlamas.planesradar.domain.model.Aircraft;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by esteban on 26/12/17
 */

public class GetAircraftsUseCase extends UseCase<List<Aircraft>> {
    private AircraftRepository aircraftRepository;

    @Inject
    public GetAircraftsUseCase(Scheduler threadExecutor,
                               PostExecutionThread postExecutionThread,
                               AircraftRepository aircraftRepository) {
        super(threadExecutor, postExecutionThread);
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public Observable<List<Aircraft>> buildObservable() {
        return aircraftRepository.getAircraftList();
    }
}
