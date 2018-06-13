package com.buoy.entity;

import com.buoy.util.Page;

public class Buoylog {
    private Integer id;

    private String date;

    private String summary;

    private String details;

    private Integer userId;
    
    private Page page;
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

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

	@Override
	public String toString() {
		return "Buoylog [id=" + id + ", date=" + date + ", summary=" + summary + ", details=" + details + ", userId="
				+ userId + ", page=" + page + "]";
	}
    
}