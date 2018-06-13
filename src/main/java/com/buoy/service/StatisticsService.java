package com.buoy.service;

import java.util.List;

import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.entity.Wind;
import com.buoy.exception.ExceptionResultInfo;

public interface StatisticsService {
	public StatisticsVo selectTheLast() throws ExceptionResultInfo;
	public StatisticsVo selectTheByDate(String buoyId,String date);
	public List<Wind> selectTheLast24(String buoyId);
	public <T> List<T> selectTuBiao(T t,String service,String buoyId);
	public <T> List<T> selectTuBiao2(T t,String field, String service,String buoyId,String time);
	public String[] selectTimeByDay(String date,String buoyId);
	public List<Station> selectAllStation();
}
