
package com.estebanlamas.planesradar.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class AircraftResponse {

    @SerializedName("Alt")
    private int altitudGround;

    @SerializedName("CNum")
    private String serial;

    @SerializedName("Call")
    private String callsign;

    @SerializedName("Cou")
    private String aircraftCountry;

    /**
     0 = Unknown
     1 = Aft Mounted
     2 = Wing Buried
     3 = Fuselage Buried
     4 = Nose Mounted
     5 = Wing Mounted
     */
    @SerializedName("EngMount")
    private short engineMount;

    /**
     0 = None
     1 = Piston
     2 = Turboprop
     3 = Jet
     4 = Electric
     */
    @SerializedName("EngType")
    private short engineType;

    @SerializedName("Engines")
    private short enginesNum;

    @SerializedName("From")
    private String from;

    @SerializedName("GAlt")
    private int altitudeSeaLevel;

    @SerializedName("Gnd")
    private boolean onGround;

    @SerializedName("Help")
    private boolean help;

    @SerializedName("Icao")
    private String idBroadcastIcao;

    @SerializedName("Interested")
    private boolean interesting;

    @SerializedName("Lat")
    private Double latitude;

    @SerializedName("Long")
    private Double longitude;

    @SerializedName("Man")
    private String manufacturer;

    @SerializedName("Mdl")
    private String modelDescription;

    @SerializedName("Mil")
    private boolean military;

    @SerializedName("Op")
    private String operator;

    @SerializedName("OpIcao")
    private String operatorIcao;

    /**
     * Tracked position time in milliseconds
     */
    @SerializedName("PosTime")
    private long positionTime;

    @SerializedName("Reg")
    private String registration;

    @SerializedName("Spd")
    private float speed;

    /**
     General Aircraft Type based on the ICAO code
     0 = None
     1 = Land Plane
     2 = Sea Plane
     3 = Amphibian
     4 = Helicopter
     5 = Gyrocopter
     6 = Tiltwing
     7 = Ground Vehicle
     8 = Tower
     */
    @SerializedName("Species")
    private short aircraftType;

    @SerializedName("Sqk")
    private String sqwak;

    @SerializedName("To")
    private String to;

    @SerializedName("Trak")
    private float heading;

    @SerializedName("Type")
    private String modelIcao;

    /**
     * Vertical speed in feet per minute
     */
    @SerializedName("Vsi")
    private int verticalSpeed;


    /**
     wake Turbulence Category
     0 = None
     1 = Light
     2 = Medium
     3 = Heavy
     */
    @SerializedName("WTC")
    private short turbulenceCategory;

    @SerializedName("Year")
    private String age;

    public int getAltitudGround() {
        return altitudGround;
    }

    public String getSerial() {
        return serial;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getAircraftCountry() {
        return aircraftCountry;
    }

    public short getEngineMount() {
        return engineMount;
    }

    public short getEngineType() {
        return engineType;
    }

    public short getEnginesNum() {
        return enginesNum;
    }

    public String getFrom() {
        return from;
    }

    public int getAltitudeSeaLevel() {
        return altitudeSeaLevel;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public boolean isHelp() {
        return help;
    }

    public String getIdBroadcastIcao() {
        return idBroadcastIcao;
    }

    public boolean isInteresting() {
        return interesting;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public boolean isMilitary() {
        return military;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperatorIcao() {
        return operatorIcao;
    }

    public long getPositionTime() {
        return positionTime;
    }

    public String getRegistration() {
        return registration;
    }

    public float getSpeed() {
        return speed;
    }

    public short getAircraftType() {
        return aircraftType;
    }

    public String getSqwak() {
        return sqwak;
    }

    public String getTo() {
        return to;
    }

    public float getHeading() {
        return heading;
    }

    public String getModelIcao() {
        return modelIcao;
    }

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    public short getTurbulenceCategory() {
        return turbulenceCategory;
    }

    public String getAge() {
        return age;
    }
}
