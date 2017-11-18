package com.estebanlamas.planesradar.data.remote;

import com.estebanlamas.planesradar.data.remote.model.AircraftListResponse;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by esteban on 24/9/17
 */

public interface AdsbExchangeApi {

    @POST("VirtualRadar/AircraftList.json?lat=40.353715&lng=-3.6113506&fDstL=0&fDstU=100")
    Call<AircraftListResponse> getAircraftList();
}
