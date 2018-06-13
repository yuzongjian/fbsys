package com.buoy.entity;

public class Station {
    private Integer sId;

    private String date;

    private String sLongitude;

    private String sLatitude;

    private String sDescribe;

    private String sStation;

    private String sBuoyid;
    
    private Integer sActive;
    
    public Integer getsActive() {
		return sActive;
	}

	public void setsActive(Integer sActive) {
		this.sActive = sActive;
	}

	public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getsLongitude() {
        return sLongitude;
    }

    public void setsLongitude(String sLongitude) {
        this.sLongitude = sLongitude == null ? null : sLongitude.trim();
    }

    public String getsLatitude() {
        return sLatitude;
    }

    public void setsLatitude(String sLatitude) {
        this.sLatitude = sLatitude == null ? null : sLatitude.trim();
    }

    public String getsDescribe() {
        return sDescribe;
    }

    public void setsDescribe(String sDescribe) {
        this.sDescribe = sDescribe == null ? null : sDescribe.trim();
    }

    public String getsStation() {
        return sStation;
    }

    public void setsStation(String sStation) {
        this.sStation = sStation == null ? null : sStation.trim();
    }

    public String getsBuoyid() {
        return sBuoyid;
    }

    public void setsBuoyid(String sBuoyid) {
        this.sBuoyid = sBuoyid == null ? null : sBuoyid.trim();
    }

	@Override
	public String toString() {
		return "Station [sId=" + sId + ", date=" + date + ", sLongitude=" + sLongitude + ", sLatitude=" + sLatitude
				+ ", sDescribe=" + sDescribe + ", sStation=" + sStation + ", sBuoyid=" + sBuoyid + "]";
	}
    
}