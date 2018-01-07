package com.estebanlamas.planesradar.domain.model

data class Aircraft (
    var altitudGround: Int,

    var serial: String,

    var callsign: String,

    var aircraftCountry: String,

    /**
     * 0 = Unknown
     * 1 = Aft Mounted
     * 2 = Wing Buried
     * 3 = Fuselage Buried
     * 4 = Nose Mounted
     * 5 = Wing Mounted
     */
    var engineMount: Short,

    /**
     * 0 = None
     * 1 = Piston
     * 2 = Turboprop
     * 3 = Jet
     * 4 = Electric
     */
    var engineType: Short,

    var enginesNum: Short,

    var from: String,

    var altitudeSeaLevel: Int,

    var isOnGround: Boolean,

    var isHelp: Boolean,

    var idBroadcastIcao: String,

    var isInteresting: Boolean,

    var latitude: Double,

    var longitude: Double,

    var manufacturer: String,

    var modelDescription: String,

    var isMilitary: Boolean,

    var operator: String,

    var operatorIcao: String,

    /**
     * Tracked position time in milliseconds
     */
    var positionTime: Long,

    var registration: String,

    var speed: Float,

    /**
     * General Aircraft Type based on the ICAO code
     * 0 = None
     * 1 = Land Plane
     * 2 = Sea Plane
     * 3 = Amphibian
     * 4 = Helicopter
     * 5 = Gyrocopter
     * 6 = Tiltwing
     * 7 = Ground Vehicle
     * 8 = Tower
     */
    var aircraftType: Short,

    var sqwak: String,

    var to: String,

    var heading: Float,

    var modelIcao: String,

    /**
     * Vertical speed in feet per minute
     */
    var verticalSpeed: Int,

    /**
     * wake Turbulence Category
     * 0 = None
     * 1 = Light
     * 2 = Medium
     * 3 = Heavy
     */
    var turbulenceCategory: Short,

    var age: String
)
