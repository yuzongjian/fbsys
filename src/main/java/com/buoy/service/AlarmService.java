package com.buoy.service;

import java.util.List;

import com.buoy.entity.Alarm;
import com.buoy.entity.Alarmlog;

public interface AlarmService {
	public List<Alarm> selectAll();
	public int updateList(List<Alarm> alarms);
	
}
