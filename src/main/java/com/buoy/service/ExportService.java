package com.buoy.service;

import java.util.List;

import com.buoy.entity.StatisticsVo;

public interface ExportService {
	/*public List<Map<String, Object>> exportData(String data[]) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;*/
	public List<StatisticsVo> exportData(String data[],String fromDay,String toDay) ;	
	

	public List<StatisticsVo> exportByDay(String data[],String day);
	public List<StatisticsVo> exportByYear(String data[],String year);
}
