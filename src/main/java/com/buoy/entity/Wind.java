package com.buoy.entity;

public class Wind {
    private Integer windId;

    private String date;

    private String windBuoyid;

    private String windSpeedMax;

    private String windSpeedMaxto;

    private String windSpeedMaxtime;

    private String windSpeedJi;

    private String windSpeedJito;

    private String windSpeedJitime;

    private String windSpeedTen;

    private String windSpeedTento;

    private String windSpeedInstant;

    private String windToInstant;

    public Integer getWindId() {
        return windId;
    }

    public void setWindId(Integer windId) {
        this.windId = windId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getWindBuoyid() {
        return windBuoyid;
    }

    public void setWindBuoyid(String windBuoyid) {
        this.windBuoyid = windBuoyid == null ? null : windBuoyid.trim();
    }

    public String getWindSpeedMax() {
        return windSpeedMax;
    }

    public void setWindSpeedMax(String windSpeedMax) {
        this.windSpeedMax = windSpeedMax == null ? null : windSpeedMax.trim();
    }

    public String getWindSpeedMaxto() {
        return windSpeedMaxto;
    }

    public void setWindSpeedMaxto(String windSpeedMaxto) {
        this.windSpeedMaxto = windSpeedMaxto == null ? null : windSpeedMaxto.trim();
    }

    public String getWindSpeedMaxtime() {
        return windSpeedMaxtime;
    }

    public void setWindSpeedMaxtime(String windSpeedMaxtime) {
        this.windSpeedMaxtime = windSpeedMaxtime == null ? null : windSpeedMaxtime.trim();
    }

    public String getWindSpeedJi() {
        return windSpeedJi;
    }

    public void setWindSpeedJi(String windSpeedJi) {
        this.windSpeedJi = windSpeedJi == null ? null : windSpeedJi.trim();
    }

    public String getWindSpeedJito() {
        return windSpeedJito;
    }

    public void setWindSpeedJito(String windSpeedJito) {
        this.windSpeedJito = windSpeedJito == null ? null : windSpeedJito.trim();
    }

    public String getWindSpeedJitime() {
        return windSpeedJitime;
    }

    public void setWindSpeedJitime(String windSpeedJitime) {
        this.windSpeedJitime = windSpeedJitime == null ? null : windSpeedJitime.trim();
    }

    public String getWindSpeedTen() {
        return windSpeedTen;
    }

    public void setWindSpeedTen(String windSpeedTen) {
        this.windSpeedTen = windSpeedTen == null ? null : windSpeedTen.trim();
    }

    public String getWindSpeedTento() {
        return windSpeedTento;
    }

    public void setWindSpeedTento(String windSpeedTento) {
        this.windSpeedTento = windSpeedTento == null ? null : windSpeedTento.trim();
    }

    public String getWindSpeedInstant() {
        return windSpeedInstant;
    }

    public void setWindSpeedInstant(String windSpeedInstant) {
        this.windSpeedInstant = windSpeedInstant == null ? null : windSpeedInstant.trim();
    }

    public String getWindToInstant() {
        return windToInstant;
    }

    public void setWindToInstant(String windToInstant) {
        this.windToInstant = windToInstant == null ? null : windToInstant.trim();
    }

	@Override
	public String toString() {
		return "Wind [windId=" + windId + ", date=" + date + ", windBuoyid=" + windBuoyid + ", windSpeedMax="
				+ windSpeedMax + ", windSpeedMaxto=" + windSpeedMaxto + ", windSpeedMaxtime=" + windSpeedMaxtime
				+ ", windSpeedJi=" + windSpeedJi + ", windSpeedJito=" + windSpeedJito + ", windSpeedJitime="
				+ windSpeedJitime + ", windSpeedTen=" + windSpeedTen + ", windSpeedTento=" + windSpeedTento
				+ ", windSpeedInstant=" + windSpeedInstant + ", windToInstant=" + windToInstant + "]";
	}
    
}