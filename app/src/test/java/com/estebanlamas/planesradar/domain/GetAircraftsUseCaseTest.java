package com.estebanlamas.planesradar.domain;

import com.estebanlamas.planesradar.domain.model.Aircraft;
import com.estebanlamas.planesradar.domain.repository.AircraftRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by esteban on 27/12/17
 */
@RunWith(MockitoJUnitRunner.class)
public class GetAircraftsUseCaseTest {
    // class under test
    private GetAircraftsUseCase getAircraftsUseCase;

    @Mock
    AircraftRepository repository;

    @Mock
    Scheduler mockUiScheduler;

    @Mock
    Scheduler mockExecutorScheduler;

    @Before
    public void setUp() throws Exception {
        getAircraftsUseCase = new GetAircraftsUseCase(mockUiScheduler, mockExecutorScheduler,repository);
    }

    @Test
    public void whenExecuteCallRepositoryOnce() throws Exception{
        when(repository.getAircraftList()).thenReturn(provideMockObservableAircraftList());

        getAircraftsUseCase.execute();

        verify(repository,times(1)).getAircraftList();
    }

    private Observable<List<Aircraft>> provideMockObservableAircraftList() {
        List<Aircraft> test = new ArrayList<>();
        test.add(new Aircraft());
        test.add(new Aircraft());
        test.add(new Aircraft());
        return Observable.just(test);
    }
}