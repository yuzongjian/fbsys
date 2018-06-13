package com.buoy.entity;

public class Buoy {
    private Integer bId;

    private String date;

    private String bBuoyid;

    private String bMnum;

    private String bRw;

    private String bLongitude;

    private String bLatitude;

    private String bBearing;

    private String bVoltage;

    private String bRidlight;

    private String bWatpolice;

    private String bDoorpolice;

    private String bShift;

    private String bHatch;

    private String bPlice;

    private String bRidlightStatus;

    private String bWatpoliceStatus;

    private String bShiftStatus;

    private String bFree;

    private String bSensor;

    private String bSensorStatus;

    private String bSensorPolice;

    private String bBreakStatus;

    private String bDatafrom;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getbBuoyid() {
        return bBuoyid;
    }

    public void setbBuoyid(String bBuoyid) {
        this.bBuoyid = bBuoyid == null ? null : bBuoyid.trim();
    }

    public String getbMnum() {
        return bMnum;
    }

    public void setbMnum(String bMnum) {
        this.bMnum = bMnum == null ? null : bMnum.trim();
    }

    public String getbRw() {
        return bRw;
    }

    public void setbRw(String bRw) {
        this.bRw = bRw == null ? null : bRw.trim();
    }

    public String getbLongitude() {
        return bLongitude;
    }

    public void setbLongitude(String bLongitude) {
        this.bLongitude = bLongitude == null ? null : bLongitude.trim();
    }

    public String getbLatitude() {
        return bLatitude;
    }

    public void setbLatitude(String bLatitude) {
        this.bLatitude = bLatitude == null ? null : bLatitude.trim();
    }

    public String getbBearing() {
        return bBearing;
    }

    public void setbBearing(String bBearing) {
        this.bBearing = bBearing == null ? null : bBearing.trim();
    }

    public String getbVoltage() {
        return bVoltage;
    }

    public void setbVoltage(String bVoltage) {
        this.bVoltage = bVoltage == null ? null : bVoltage.trim();
    }

    public String getbRidlight() {
        return bRidlight;
    }

    public void setbRidlight(String bRidlight) {
        this.bRidlight = bRidlight == null ? null : bRidlight.trim();
    }

    public String getbWatpolice() {
        return bWatpolice;
    }

    public void setbWatpolice(String bWatpolice) {
        this.bWatpolice = bWatpolice == null ? null : bWatpolice.trim();
    }

    public String getbDoorpolice() {
        return bDoorpolice;
    }

    public void setbDoorpolice(String bDoorpolice) {
        this.bDoorpolice = bDoorpolice == null ? null : bDoorpolice.trim();
    }

    public String getbShift() {
        return bShift;
    }

    public void setbShift(String bShift) {
        this.bShift = bShift == null ? null : bShift.trim();
    }

    public String getbHatch() {
        return bHatch;
    }

    public void setbHatch(String bHatch) {
        this.bHatch = bHatch == null ? null : bHatch.trim();
    }

    public String getbPlice() {
        return bPlice;
    }

    public void setbPlice(String bPlice) {
        this.bPlice = bPlice == null ? null : bPlice.trim();
    }

    public String getbRidlightStatus() {
        return bRidlightStatus;
    }

    public void setbRidlightStatus(String bRidlightStatus) {
        this.bRidlightStatus = bRidlightStatus == null ? null : bRidlightStatus.trim();
    }

    public String getbWatpoliceStatus() {
        return bWatpoliceStatus;
    }

    public void setbWatpoliceStatus(String bWatpoliceStatus) {
        this.bWatpoliceStatus = bWatpoliceStatus == null ? null : bWatpoliceStatus.trim();
    }

    public String getbShiftStatus() {
        return bShiftStatus;
    }

    public void setbShiftStatus(String bShiftStatus) {
        this.bShiftStatus = bShiftStatus == null ? null : bShiftStatus.trim();
    }

    public String getbFree() {
        return bFree;
    }

    public void setbFree(String bFree) {
        this.bFree = bFree == null ? null : bFree.trim();
    }

    public String getbSensor() {
        return bSensor;
    }

    public void setbSensor(String bSensor) {
        this.bSensor = bSensor == null ? null : bSensor.trim();
    }

    public String getbSensorStatus() {
        return bSensorStatus;
    }

    public void setbSensorStatus(String bSensorStatus) {
        this.bSensorStatus = bSensorStatus == null ? null : bSensorStatus.trim();
    }

    public String getbSensorPolice() {
        return bSensorPolice;
    }

    public void setbSensorPolice(String bSensorPolice) {
        this.bSensorPolice = bSensorPolice == null ? null : bSensorPolice.trim();
    }

    public String getbBreakStatus() {
        return bBreakStatus;
    }

    public void setbBreakStatus(String bBreakStatus) {
        this.bBreakStatus = bBreakStatus == null ? null : bBreakStatus.trim();
    }

    public String getbDatafrom() {
        return bDatafrom;
    }

    public void setbDatafrom(String bDatafrom) {
        this.bDatafrom = bDatafrom == null ? null : bDatafrom.trim();
    }

	@Override
	public String toString() {
		return "Buoy [bId=" + bId + ", date=" + date + ", bBuoyid=" + bBuoyid + ", bMnum=" + bMnum + ", bRw=" + bRw
				+ ", bLongitude=" + bLongitude + ", bLatitude=" + bLatitude + ", bBearing=" + bBearing + ", bVoltage="
				+ bVoltage + ", bRidlight=" + bRidlight + ", bWatpolice=" + bWatpolice + ", bDoorpolice=" + bDoorpolice
				+ ", bShift=" + bShift + ", bHatch=" + bHatch + ", bPlice=" + bPlice + ", bRidlightStatus="
				+ bRidlightStatus + ", bWatpoliceStatus=" + bWatpoliceStatus + ", bShiftStatus=" + bShiftStatus
				+ ", bFree=" + bFree + ", bSensor=" + bSensor + ", bSensorStatus=" + bSensorStatus + ", bSensorPolice="
				+ bSensorPolice + ", bBreakStatus=" + bBreakStatus + ", bDatafrom=" + bDatafrom + "]";
	}
    
}