package com.estebanlamas.planesradar.data.remote.response

import com.google.gson.annotations.SerializedName

class AircraftListResponse {

    @SerializedName("acList")
    val acList: List<AircraftResponse> = emptyList()
}
