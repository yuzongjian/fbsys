package com.buoy.service;

import java.util.List;
import java.util.Map;

import com.buoy.entity.Alarmlog;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;

public interface MapService {
	public Map<String, Object> selectByLastTime(String time,List<Station> stations);
	public List<Alarmlog> selectLogByBuoyIdAndDate(String buoy,String day);
	public StatisticsVo getPreOrNext(String buoy,String time,int type);
}
