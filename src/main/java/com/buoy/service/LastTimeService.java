package com.buoy.service;

public interface LastTimeService {
	public String selectByBuoyName(String buoyName);
	public int updateWithDate(String date,String buoyName);
	public String selectBuoyLastTime(String time,String buoy);
}
