package com.buoy.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Alarmlog;
import com.buoy.entity.Buoy;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.mapper.AlarmMapper;
import com.buoy.mapper.AlarmlogMapper;
import com.buoy.mapper.ExportMapper;
import com.buoy.mapper.LasttimeMapper;
import com.buoy.service.MapService;
import com.buoy.util.StringUtil;
import com.hxtt.sql.da;
@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private ExportMapper exportMapper;
	@Autowired
	private AlarmlogMapper alarmlogMapper;
	@Autowired
	private LasttimeMapper lasttimeMapper;

	@Override
	public Map<String, Object> selectByLastTime(String time,List<Station> stations) {
		
		List<StatisticsVo> list = new ArrayList<>();
		List<Station> noDataBuoys = new ArrayList<>();
		for (Station s:stations) {
			String lastTime = lasttimeMapper.selectBuoyLastTime(time, s.getsBuoyid());
			if (lastTime != null) {
				String nowTime = StringUtil.getNowTime("yyMMddHHmm");
				StatisticsVo buoy = exportMapper.selectBuoyByTime(lastTime, s.getsBuoyid());
				buoy.setStation(s.getsStation());
				//故障判断 24小时未取得数据表示故障
				if (Long.parseLong(nowTime) - Long.parseLong(lastTime) > 10000) {
					buoy.setIsFault(1);
				}else {
					buoy.setIsFault(0);
				}
				list.add(buoy);
			}else {
				noDataBuoys.add(s);
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("buoys", list);
		map.put("nodatabuoys", noDataBuoys);
		
		return map;
	}

	@Override
	public List<Alarmlog> selectLogByBuoyIdAndDate(String buoy,String day) {
		day = day.substring(0, day.length() - 3);
		return alarmlogMapper.selectLogByBuoyIdAndDate(buoy, day);
	}

	@Override
	public StatisticsVo getPreOrNext(String buoy, String time, int type) {
		String ortherTime = null;
		StatisticsVo statisticsVo = null;
		ortherTime = lasttimeMapper.selectPreOrNextTime(time, buoy, type);
		if (ortherTime != null) {
			statisticsVo = exportMapper.selectBuoyByTime(ortherTime, buoy);
		}else {
			statisticsVo = null;
		}
		return statisticsVo;
	}

}
