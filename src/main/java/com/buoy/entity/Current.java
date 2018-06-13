package com.buoy.entity;

public class Current {
    private Integer cId;

    private String date;

    private String cBuoyid;

    private String cSpeed1;

    private String cTo1;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getcBuoyid() {
        return cBuoyid;
    }

    public void setcBuoyid(String cBuoyid) {
        this.cBuoyid = cBuoyid == null ? null : cBuoyid.trim();
    }

    public String getcSpeed1() {
        return cSpeed1;
    }

    public void setcSpeed1(String cSpeed1) {
        this.cSpeed1 = cSpeed1 == null ? null : cSpeed1.trim();
    }

    public String getcTo1() {
        return cTo1;
    }

    public void setcTo1(String cTo1) {
        this.cTo1 = cTo1 == null ? null : cTo1.trim();
    }
}