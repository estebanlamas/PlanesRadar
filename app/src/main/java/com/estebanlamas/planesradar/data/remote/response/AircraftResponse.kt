package com.estebanlamas.planesradar.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * https://www.adsbexchange.com/datafields/
 */
class AircraftResponse {

    @SerializedName("Alt")
    val altitudGround: Int = 0

    @SerializedName("CNum")
    val serial: String = ""

    @SerializedName("Call")
    val callsign: String = ""

    @SerializedName("Cou")
    val aircraftCountry: String = ""

    @SerializedName("EngMount")
    val engineMount: Short = 0

    @SerializedName("EngType")
    val engineType: Short = 0

    @SerializedName("Engines")
    val enginesNum: Short = 0

    @SerializedName("From")
    val from: String = ""

    @SerializedName("GAlt")
    val altitudeSeaLevel: Int = 0

    @SerializedName("Gnd")
    val isOnGround: Boolean = false

    @SerializedName("Help")
    val isHelp: Boolean = false

    @SerializedName("Icao")
    val idBroadcastIcao: String = ""

    @SerializedName("Interested")
    val isInteresting: Boolean = false

    @SerializedName("Lat")
    val latitude: Double = 0.0

    @SerializedName("Long")
    val longitude: Double = 0.0

    @SerializedName("Man")
    val manufacturer: String = ""

    @SerializedName("Mdl")
    val modelDescription: String = ""

    @SerializedName("Mil")
    val isMilitary: Boolean = false

    @SerializedName("Op")
    val operator: String = ""

    @SerializedName("OpIcao")
    val operatorIcao: String = ""

    @SerializedName("PosTime")
    val positionTime: Long = 0

    @SerializedName("Reg")
    val registration: String = ""

    @SerializedName("Spd")
    val speed: Float = 0.toFloat()

    @SerializedName("Species")
    val aircraftType: Short = 0

    @SerializedName("Sqk")
    val sqwak: String = ""

    @SerializedName("To")
    val to: String = ""

    @SerializedName("Trak")
    val heading: Float = 0.toFloat()

    @SerializedName("Type")
    val modelIcao: String = ""

    @SerializedName("Vsi")
    val verticalSpeed: Int = 0

    @SerializedName("WTC")
    val turbulenceCategory: Short = 0

    @SerializedName("Year")
    val age: String = ""
}
