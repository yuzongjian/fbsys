package com.buoy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.ReceiveTime;
import com.buoy.mapper.ReceiveTimeMapper;
import com.buoy.service.ReceiveTimeService;
@Service
public class ReceiveTimeServiceImpl implements ReceiveTimeService{
	
	@Autowired
	private ReceiveTimeMapper mapper;
	
	@Override
	public ReceiveTime getByBuoyId(Integer id) {
		return mapper.getByBuoyId(id);
	}

	@Override
	public List<ReceiveTime> getListByStatus(Integer status) {
		return mapper.getListByStatus(status);
	}

	@Override
	public int updateBuoyById(String time, Integer id) {
		return mapper.updateBuoyById(time, id);
	}

	@Override
	public int updateCurrentById(String time, Integer id) {
		return mapper.updateCurrentById(time, id);
	}

	@Override
	public int updateWaterqualityById(String time, Integer id) {
		return mapper.updateWaterqualityById(time, id);
	}

	@Override
	public int updateWaveById(String time, Integer id) {
		return mapper.updateWaveById(time, id);
	}

	@Override
	public int updateWeatherById(String time, Integer id) {
		return mapper.updateWeatherById(time, id);
	}

	@Override
	public int updateWindById(String time, Integer id) {
		return mapper.updateWindById(time, id);
	}

}
