package com.estebanlamas.planesradar.data;

import com.estebanlamas.planesradar.BuildConfig;
import com.estebanlamas.planesradar.data.common.MockApiResponse;
import com.estebanlamas.planesradar.data.common.TestNetworkModule;
import com.estebanlamas.planesradar.domain.model.Aircraft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;

/**
 * Created by esteban on 25/11/17
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class AircraftRepositoryTest extends MockWebServerTest {
    private AircraftDataRepository aircraftRepository;
    private TestNetworkModule networkModule;
    private TestSubscriber<List<Aircraft>> subscriber = new TestSubscriber<>();

    public AircraftRepositoryTest() {
        networkModule = new TestNetworkModule();
    }

    @Before
    public void setUp() throws Exception {
        server = networkModule.getMockWebServer();
        aircraftRepository = new AircraftDataRepository(networkModule.getApiService());
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void onExecuteReturnAllAicrafts() throws Exception {
        server.enqueue(MockApiResponse.serviceAircraftListOk());
        Observable<List<Aircraft>> aircrafts =  aircraftRepository.getAircraftList();

        aircrafts.subscribe(subscriber);

        assertEquals(16,subscriber.getOnNextEvents().get(0).size());
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
    }

    @Test
    public void onExecuteReturnAicraftInfo() throws Exception {
        server.enqueue(MockApiResponse.serviceAircraftListOk());
        Observable<List<Aircraft>> aircrafts =  aircraftRepository.getAircraftList();

        aircrafts.subscribe(subscriber);

        List<Aircraft> aircraftList = subscriber.getOnNextEvents().get(0);
        assertEqualsAircraft(aircraftList.get(0));
    }

    private void assertEqualsAircraft(Aircraft aircraft){
        assertEquals("B-8226", aircraft.getRegistration());
        assertEquals("78028E", aircraft.getIdBroadcastIcao());
        assertEquals("Airbus A330 243", aircraft.getModelDescription());
    }
}