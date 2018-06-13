package com.buoy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.buoy.entity.ReceiveTime;

public interface ReceiveTimeMapper {
	ReceiveTime getByBuoyId(@Param("id") Integer id);
	List<ReceiveTime> getListByStatus(@Param("status") Integer status);
	int updateBuoyById(@Param("time") String time, @Param("id") Integer id);
	int updateCurrentById(@Param("time") String time, @Param("id") Integer id);
	int updateWaterqualityById(@Param("time") String time, @Param("id") Integer id);
	int updateWaveById(@Param("time") String time, @Param("id") Integer id);
	int updateWeatherById(@Param("time") String time, @Param("id") Integer id);
	int updateWindById(@Param("time") String time, @Param("id") Integer id);
	int updateStatus(@Param("status") Integer status, @Param("buoyId") Integer id);
	int updateBuoyName(@Param("name") String name, @Param("buoyId") Integer id);
	int insert(@Param("rt") ReceiveTime receiveTime);
}
