package com.buoy.entity;

import java.io.Serializable;

public class ReceiveTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 401830397655706136L;
	private Integer id;
	//浮标id
	private Integer buoyId;
	//浮标名
	private String buoyName;
	//浮标基本信息时间
	private String buoy;
	//海流时间
	private String current;
	//水质时间
	private String waterQuality;
	//波时间
	private String wave;
	//天气时间
	private String weather;
	//风时间
	private String wind;
	//标志 0未删除 1删除
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuoyId() {
		return buoyId;
	}
	public void setBuoyId(Integer buoyId) {
		this.buoyId = buoyId;
	}
	public String getBuoyName() {
		return buoyName;
	}
	public void setBuoyName(String buoyName) {
		this.buoyName = buoyName;
	}
	public String getBuoy() {
		return buoy;
	}
	public void setBuoy(String buoy) {
		this.buoy = buoy;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getWaterQuality() {
		return waterQuality;
	}
	public void setWaterQuality(String waterQuality) {
		this.waterQuality = waterQuality;
	}
	public String getWave() {
		return wave;
	}
	public void setWave(String wave) {
		this.wave = wave;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReceiveTime [id=" + id + ", buoyId=" + buoyId + ", buoyName=" + buoyName + ", buoy=" + buoy
				+ ", current=" + current + ", waterQuality=" + waterQuality + ", wave=" + wave + ", weather=" + weather
				+ ", wind=" + wind + ", status=" + status + "]";
	}
	
	
	
}
