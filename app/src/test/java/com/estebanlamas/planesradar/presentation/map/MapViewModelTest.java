package com.estebanlamas.planesradar.presentation.map;

import com.estebanlamas.planesradar.domain.GetAircraftsUseCase;
import com.estebanlamas.planesradar.domain.model.Aircraft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by esteban on 27/12/17
 */
@RunWith(MockitoJUnitRunner.class)
public class MapViewModelTest {
    private MapViewModel presenter;

    @Mock
    MapView mapView;

    @Mock
    GetAircraftsUseCase getAircraftsUseCase;

    @Before
    public void setUp() throws Exception {
        presenter = new MapViewModel(getAircraftsUseCase);
        presenter.attachView(mapView);
    }

    @Test
    public void onResumeRequestAircrafts() throws Exception{
        List<Aircraft> test = provideMockAircraftList();
        when(getAircraftsUseCase.execute()).thenReturn(provideMockObservable(test));

        presenter.onResume();

        verify(getAircraftsUseCase).execute();
        Thread.sleep(100); // wait for the timer task
        verify(mapView).updateAircrafts(test);
    }

    private List<Aircraft> provideMockAircraftList(){
        List<Aircraft> test = new ArrayList<>();
        test.add(new Aircraft());
        test.add(new Aircraft());
        test.add(new Aircraft());
        return  test;
    }

    private Observable<List<Aircraft>> provideMockObservable(List<Aircraft> test) {
        return Observable.just(test);
    }

}