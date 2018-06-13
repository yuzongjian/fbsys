package com.buoy.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Buoylog;
import com.buoy.entity.ReceiveTime;
import com.buoy.entity.Station;
import com.buoy.mapper.BuoylogMapper;
import com.buoy.mapper.ReceiveTimeMapper;
import com.buoy.mapper.StationMapper;
import com.buoy.service.BuoyService;
import com.buoy.util.StringUtil;
@Service
public class BuoyServiceImpl implements BuoyService{
	protected static Logger logger = Logger.getLogger(BuoyServiceImpl.class);

	
	@Autowired
	private StationMapper stationMapper;
	@Autowired
	private BuoylogMapper buoylogMapper;
	@Autowired
	private ReceiveTimeMapper receiveTimeMapper;
	
	@Override
	public List<Station> selectAll() {
		List<Station> stations = stationMapper.selectAll();
		return stations;
	}

	@Override
	public Station selectByStation(String stationId) {
		Station station = stationMapper.selectByStation(stationId);
		return station;
	}

	@Override
	public int updateStation(Station station,String username) {
		
		int i = stationMapper.saveOrUpdate(station);
		if (i == 2) {
			//更新浮标接受数据时间记录
			receiveTimeMapper.updateBuoyName(station.getsBuoyid(), station.getsId());
			Buoylog buoylog = new Buoylog();
			buoylog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
			buoylog.setSummary("更新浮标");
			buoylog.setDetails("管理员"+username+"更新浮标："+station.getsDescribe());
			buoylog.setUserId(1);
			int result = buoylogMapper.insert(buoylog);
			if (result == 1) {
				logger.info("记录浮标更新日志");
			}
		}
		return i;
	}

	@Override
	public Map<String, Object> updateStation(List<Station> stations,String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("update", 0);
		map.put("insert", 0);
		map.put("fail", 0);
		Buoylog buoylog = new Buoylog();
		for (Station s: stations) {
			int i = stationMapper.saveOrUpdate(s);
			if (i == 2) {
				if (s.getsActive() == 1) {
					//删除浮标接受数据时间记录
					receiveTimeMapper.updateStatus(s.getsActive(), s.getsId());
				}else {
					//更新浮标接受数据时间记录
					receiveTimeMapper.updateBuoyName(s.getsBuoyid(), s.getsId());
				}
				buoylog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
				buoylog.setSummary("更新浮标");
				buoylog.setDetails("管理员"+username+"更新浮标："+s.getsDescribe());
				buoylog.setUserId(1);
				int result = buoylogMapper.insert(buoylog);
				if (result == 1) {
					logger.info("记录浮标更新日志");
				}
				map.put("update", (Integer)map.get("update")+1);
			}
			if (i == 1) {
				//新增浮标接受数据时间记录
				createReceiveEntity(s);
				
				buoylog.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
				buoylog.setSummary("新建站位");
				buoylog.setDetails("管理员"+username+"新建站位："+s.getsDescribe());
				buoylog.setUserId(1);
				int result = buoylogMapper.insert(buoylog);
				if (result == 1) {
					logger.info("记录站位新增日志");
				}
				map.put("insert", (Integer)map.get("insert")+1);
			}
			if (i == 0) {
				logger.info("更新或新建失败");
				map.put("fail", (Integer)map.get("fail")+1);
			}
		}
		return map;
	}
	
	
	void createReceiveEntity(Station s) {
		ReceiveTime rt = new ReceiveTime();
		rt.setBuoyId(s.getsId());
		rt.setBuoyName(s.getsBuoyid());
		String time = StringUtil.getNowTime("yyMMddHHmm");
		rt.setBuoy(time);
		rt.setCurrent(time);
		rt.setWaterQuality(time);
		rt.setWave(time);
		rt.setWeather(time);
		rt.setWind(time);
		receiveTimeMapper.insert(rt);
	}
}
