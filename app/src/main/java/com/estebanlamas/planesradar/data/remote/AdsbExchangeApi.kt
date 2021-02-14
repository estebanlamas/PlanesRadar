package com.estebanlamas.planesradar.data.remote

import com.estebanlamas.planesradar.data.remote.response.AircraftListResponse
import retrofit2.http.POST


/**
 * Created by esteban on 24/9/17
 */

interface AdsbExchangeApi {

    @POST("VirtualRadar/AircraftList.json?lat=40.353715&lng=-3.6113506&fDstL=0&fDstU=100")
    suspend fun aircraftList(): AircraftListResponse
}
