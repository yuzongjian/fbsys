package com.buoy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Lasttime;
import com.buoy.entity.LasttimeExample;
import com.buoy.mapper.LasttimeMapper;
import com.buoy.service.LastTimeService;
@Service
public class LastTimeImpl implements LastTimeService {

	@Autowired
	private LasttimeMapper lasttimeMapper;
	
	@Override
	public String selectByBuoyName(String buoyName) {
		if (null == buoyName || "".equals(buoyName)) {
			//todo
			
		}
		LasttimeExample example = new LasttimeExample();
		example.createCriteria().andLtBuoyEqualTo(buoyName);
		List<Lasttime> result = lasttimeMapper.selectByExample(example);
		if (null == result || result.size() <= 0){
			//todo
		}
		return result.get(0).getLtDate();
	}

	@Override
	public int updateWithDate(String date,String buoyName) {
		if (null == date || "".equals(date)) {
			return 0;
		}
		if (null == buoyName || "".equals(buoyName)) {
			return 0;
		}
		int i = lasttimeMapper.updateByBuoy(date, buoyName);
		return i;
	}

	@Override
	public String selectBuoyLastTime(String time, String buoy) {
		// TODO Auto-generated method stub
		return lasttimeMapper.selectBuoyLastTime(time, buoy);
	}
}
