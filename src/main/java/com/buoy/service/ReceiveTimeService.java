package com.buoy.service;

import java.util.List;

import com.buoy.entity.ReceiveTime;

public interface ReceiveTimeService {
	ReceiveTime getByBuoyId(Integer id);
	/**
	 * 根据状态获取浮标列表
	 */
	List<ReceiveTime> getListByStatus(Integer status);
	/**
	 * 更新buoy时间
	 */
	int updateBuoyById(String time,Integer id);
	int updateCurrentById(String time,Integer id);
	int updateWaterqualityById(String time,Integer id);
	int updateWaveById(String time,Integer id);
	int updateWeatherById(String time,Integer id);
	int updateWindById(String time,Integer id);
}
