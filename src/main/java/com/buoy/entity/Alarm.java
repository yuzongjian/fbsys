package com.buoy.entity;

public class Alarm {
    private Integer id;

    private String type;

    private String from;

    private String to;

    private Integer active;

    private String date;

    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", type=" + type + ", from=" + from + ", to=" + to + ", active=" + active + ", date="
				+ date + ", describe=" + describe + "]";
	}
    
    
    
    
}