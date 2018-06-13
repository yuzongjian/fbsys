package com.buoy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Alarm;
import com.buoy.mapper.AlarmMapper;
import com.buoy.service.AlarmService;
@Service
public class AlarmServiceImpl implements AlarmService{

	@Autowired
	private AlarmMapper alarmMapper;
	@Override
	public List<Alarm> selectAll() {
		return alarmMapper.selectAll();
	}
	@Override
	public int updateList(List<Alarm> alarms) {
		int result = 0;
		for (Alarm alarm:alarms) {
			int i = alarmMapper.updateByType(alarm);
			result += i;
		}
		
		return result;
	}

}
