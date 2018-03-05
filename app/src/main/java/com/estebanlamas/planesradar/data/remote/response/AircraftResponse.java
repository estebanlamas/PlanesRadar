
package com.estebanlamas.planesradar.data.remote.response;

import com.google.gson.annotations.SerializedName;

/**
 * https://www.adsbexchange.com/datafields/
 */
public class AircraftResponse {

    @SerializedName("Alt")
    private int altitudGround;

    @SerializedName("CNum")
    private String serial;

    @SerializedName("Call")
    private String callsign;

    @SerializedName("Cou")
    private String aircraftCountry;

    @SerializedName("EngMount")
    private short engineMount;

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

    @SerializedName("PosTime")
    private long positionTime;

    @SerializedName("Reg")
    private String registration;

    @SerializedName("Spd")
    private float speed;

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

    @SerializedName("Vsi")
    private int verticalSpeed;

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
        return callsign==null?"":callsign;
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
        return from!=null?from:"";
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
        return to!=null?to:"";
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
