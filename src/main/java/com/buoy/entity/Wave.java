package com.buoy.entity;

public class Wave {
    private Integer wId;

    private String date;

    private String wBuoyid;

    private String wHighMax;

    private String wHighTenth;

    private String wHighAverage;

    private String wHighEffective;

    private String wCycleMax;

    private String wCycleTenth;

    private String wCycleAverage;

    private String wCycleEffective;

    private String wTo;

    private String wCount;

    private String wDateid;

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getwBuoyid() {
        return wBuoyid;
    }

    public void setwBuoyid(String wBuoyid) {
        this.wBuoyid = wBuoyid == null ? null : wBuoyid.trim();
    }

    public String getwHighMax() {
        return wHighMax;
    }

    public void setwHighMax(String wHighMax) {
        this.wHighMax = wHighMax == null ? null : wHighMax.trim();
    }

    public String getwHighTenth() {
        return wHighTenth;
    }

    public void setwHighTenth(String wHighTenth) {
        this.wHighTenth = wHighTenth == null ? null : wHighTenth.trim();
    }

    public String getwHighAverage() {
        return wHighAverage;
    }

    public void setwHighAverage(String wHighAverage) {
        this.wHighAverage = wHighAverage == null ? null : wHighAverage.trim();
    }

    public String getwHighEffective() {
        return wHighEffective;
    }

    public void setwHighEffective(String wHighEffective) {
        this.wHighEffective = wHighEffective == null ? null : wHighEffective.trim();
    }

    public String getwCycleMax() {
        return wCycleMax;
    }

    public void setwCycleMax(String wCycleMax) {
        this.wCycleMax = wCycleMax == null ? null : wCycleMax.trim();
    }

    public String getwCycleTenth() {
        return wCycleTenth;
    }

    public void setwCycleTenth(String wCycleTenth) {
        this.wCycleTenth = wCycleTenth == null ? null : wCycleTenth.trim();
    }

    public String getwCycleAverage() {
        return wCycleAverage;
    }

    public void setwCycleAverage(String wCycleAverage) {
        this.wCycleAverage = wCycleAverage == null ? null : wCycleAverage.trim();
    }

    public String getwCycleEffective() {
        return wCycleEffective;
    }

    public void setwCycleEffective(String wCycleEffective) {
        this.wCycleEffective = wCycleEffective == null ? null : wCycleEffective.trim();
    }

    public String getwTo() {
        return wTo;
    }

    public void setwTo(String wTo) {
        this.wTo = wTo == null ? null : wTo.trim();
    }

    public String getwCount() {
        return wCount;
    }

    public void setwCount(String wCount) {
        this.wCount = wCount == null ? null : wCount.trim();
    }

    public String getwDateid() {
        return wDateid;
    }

    public void setwDateid(String wDateid) {
        this.wDateid = wDateid == null ? null : wDateid.trim();
    }
}