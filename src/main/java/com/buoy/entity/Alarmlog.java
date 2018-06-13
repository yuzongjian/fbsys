package com.buoy.entity;

public class Alarmlog {
    private Integer id;

    private String date;

    private String summary;

    private String details;

    private Integer userId;

    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

	@Override
	public String toString() {
		return "Alarmlog [id=" + id + ", date=" + date + ", summary=" + summary + ", details=" + details + ", userId="
				+ userId + ", active=" + active + "]";
	}
    
    
}