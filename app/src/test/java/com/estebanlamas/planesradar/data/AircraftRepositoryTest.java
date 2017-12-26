package com.estebanlamas.planesradar.data;

import android.arch.lifecycle.LiveData;

import com.estebanlamas.planesradar.BuildConfig;
import com.estebanlamas.planesradar.data.common.MockApiResponse;
import com.estebanlamas.planesradar.data.common.TestNetworkModule;
import com.estebanlamas.planesradar.presentation.model.Aircraft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by esteban on 25/11/17
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class AircraftRepositoryTest extends MockWebServerTest {
    private AircraftRepository aircraftRepository;
    private TestNetworkModule networkModule;


    public AircraftRepositoryTest() {
        networkModule = new TestNetworkModule();
    }

    @Before
    public void setUp() throws Exception {
        server = networkModule.getMockWebServer();
        aircraftRepository = new AircraftRepository(networkModule.getApiService());
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void onExecuteReturnAllAicrafts() throws Exception {
        server.enqueue(MockApiResponse.serviceAircraftListOk());
        final LiveData<List<Aircraft>> aircrafts =  aircraftRepository.getAircraftList();
        assertEquals(200,aircrafts.getValue().size());
    }
}