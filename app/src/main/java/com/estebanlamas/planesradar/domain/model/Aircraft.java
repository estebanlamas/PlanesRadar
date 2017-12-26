package com.estebanlamas.planesradar.domain.model;

public class Aircraft {
    private int altitudGround;

    private String serial;

    private String callsign;

    private String aircraftCountry;

    /**
     0 = Unknown
     1 = Aft Mounted
     2 = Wing Buried
     3 = Fuselage Buried
     4 = Nose Mounted
     5 = Wing Mounted
     */
    private short engineMount;

    /**
     0 = None
     1 = Piston
     2 = Turboprop
     3 = Jet
     4 = Electric
     */
    private short engineType;

    private short enginesNum;

    private String from;

    private int altitudeSeaLevel;

    private boolean onGround;

    private boolean help;

    private String idBroadcastIcao;

    private boolean interesting;

    private Double latitude;

    private Double longitude;

    private String manufacturer;

    private String modelDescription;

    private boolean military;

    private String operator;

    private String operatorIcao;

    /**
     * Tracked position time in milliseconds
     */
    private long positionTime;

    private String registration;

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
    private short aircraftType;

    private String sqwak;

    private String to;

    private float heading;

    private String modelIcao;

    /**
     * Vertical speed in feet per minute
     */
    private int verticalSpeed;

    /**
     wake Turbulence Category
     0 = None
     1 = Light
     2 = Medium
     3 = Heavy
     */
    private short turbulenceCategory;

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

    public void setAltitudGround(int altitudGround) {
        this.altitudGround = altitudGround;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public void setAircraftCountry(String aircraftCountry) {
        this.aircraftCountry = aircraftCountry;
    }

    public void setEngineMount(short engineMount) {
        this.engineMount = engineMount;
    }

    public void setEngineType(short engineType) {
        this.engineType = engineType;
    }

    public void setEnginesNum(short enginesNum) {
        this.enginesNum = enginesNum;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setAltitudeSeaLevel(int altitudeSeaLevel) {
        this.altitudeSeaLevel = altitudeSeaLevel;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public void setIdBroadcastIcao(String idBroadcastIcao) {
        this.idBroadcastIcao = idBroadcastIcao;
    }

    public void setInteresting(boolean interesting) {
        this.interesting = interesting;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperatorIcao(String operatorIcao) {
        this.operatorIcao = operatorIcao;
    }

    public void setPositionTime(long positionTime) {
        this.positionTime = positionTime;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setAircraftType(short aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setSqwak(String sqwak) {
        this.sqwak = sqwak;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public void setModelIcao(String modelIcao) {
        this.modelIcao = modelIcao;
    }

    public void setVerticalSpeed(int verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public void setTurbulenceCategory(short turbulenceCategory) {
        this.turbulenceCategory = turbulenceCategory;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
