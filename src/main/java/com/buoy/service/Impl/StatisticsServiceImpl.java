package com.buoy.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Buoy;
import com.buoy.entity.Current;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.entity.Waterquality;
import com.buoy.entity.Wave;
import com.buoy.entity.Weather;
import com.buoy.entity.Wind;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.mapper.BuoyMapper;
import com.buoy.mapper.CurrentMapper;
import com.buoy.mapper.StationMapper;
import com.buoy.mapper.WaterqualityMapper;
import com.buoy.mapper.WaveMapper;
import com.buoy.mapper.WeatherMapper;
import com.buoy.mapper.WindMapper;
import com.buoy.service.StatisticsService;
import com.buoy.util.Constant;
import com.buoy.util.FbUtil;
import com.buoy.util.StringUtil;
import com.mysql.jdbc.PreparedStatement;
@Service
public class StatisticsServiceImpl implements StatisticsService{
	
	@Autowired
	private BuoyMapper buoyMapper;
	@Autowired
	private CurrentMapper currentMapper;
	@Autowired
	private WaterqualityMapper waterqualityMapper;
	@Autowired
	private WaveMapper waveMapper;
	@Autowired
	private WeatherMapper weatherMapper;
	@Autowired
	private WindMapper windMapper;
	@Autowired
	private StationMapper stationMapper;
	
	@Override
	public StatisticsVo selectTheLast() throws ExceptionResultInfo {
		
		List<Station> stations = stationMapper.selectAll();
		StatisticsVo statisticsVo = new StatisticsVo();
		String buoyId = null;
		if (stations.size() == 0) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "未找到相关浮标信息");
		}else {
			buoyId = stations.get(0).getsBuoyid();
			statisticsVo.setStation(stations.get(0).getsStation());
			statisticsVo.setoLongitude(stations.get(0).getsLongitude());
			statisticsVo.setoLatitude(stations.get(0).getsLatitude());
		}
		
		Buoy buoy = buoyMapper.selectTheLast(buoyId);
		if (buoy != null) {
//			StringUtil.changeToLAL()
			buoy.setbLatitude(buoy.getbLatitude());
			buoy.setbLongitude(buoy.getbLongitude());
			Current current = currentMapper.selectTheLast(buoyId);
			Waterquality waterquality = waterqualityMapper.selectTheLast(buoyId);
			Wave wave = waveMapper.selectTheLast(buoyId);
			Weather weather = weatherMapper.selectTheLast(buoyId);
			Wind wind = windMapper.selectTheLast(buoyId);
			String time = StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", buoy.getDate());
			statisticsVo.setTime(time);
			BeanUtils.copyProperties(buoy, statisticsVo);
			BeanUtils.copyProperties(current, statisticsVo);
			BeanUtils.copyProperties(waterquality, statisticsVo);
			BeanUtils.copyProperties(wave, statisticsVo);
			BeanUtils.copyProperties(weather, statisticsVo);
			BeanUtils.copyProperties(wind, statisticsVo);
			Double stateCalculate = FbUtil.stateCalculate(buoy.getbLongitude().substring(0, buoy.getbLongitude().length() - 1),
														buoy.getbLatitude().substring(0, buoy.getbLatitude().length() - 1), 
														statisticsVo.getoLongitude().substring(0, statisticsVo.getoLongitude().length()), 
														statisticsVo.getoLatitude().substring(0, statisticsVo.getoLatitude().length()));
			statisticsVo.setMoveDistance(stateCalculate.toString().length() > 6?stateCalculate.toString().substring(0,6) : stateCalculate.toString());
		}
		
		
		return statisticsVo;
	}
	
	@Override
	public StatisticsVo selectTheByDate(String buoyId,String date) {
		StatisticsVo statisticsVo = null;
		Buoy buoy = buoyMapper.selectDateByDay(buoyId, date);
		Station station = stationMapper.selectByBuoyId(buoyId);
		if (buoy != null && station != null) {
			statisticsVo = new StatisticsVo();
			//设置原始浮标数据
			statisticsVo.setStation(station.getsStation());
			statisticsVo.setoLongitude(station.getsLongitude());
			statisticsVo.setoLatitude(station.getsLatitude());
			
			buoy.setbLatitude(buoy.getbLatitude());
			buoy.setbLongitude(buoy.getbLongitude());
			
			Current current = currentMapper.selectDateByDay(buoyId, date);
			Waterquality waterquality = waterqualityMapper.selectDateByDay(buoyId, date);
			Wave wave = waveMapper.selectDateByDay(buoyId, date);
			Weather weather = weatherMapper.selectDateByDay(buoyId, date);
			Wind wind = windMapper.selectDateByDay(buoyId, date);
			
			String time = StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", buoy.getDate());
			statisticsVo.setTime(time);
			BeanUtils.copyProperties(buoy, statisticsVo);
			BeanUtils.copyProperties(current, statisticsVo);
			BeanUtils.copyProperties(waterquality, statisticsVo);
			BeanUtils.copyProperties(wave, statisticsVo);
			BeanUtils.copyProperties(weather, statisticsVo);
			BeanUtils.copyProperties(wind, statisticsVo);
			
			//计算偏移位置
			Double stateCalculate = FbUtil.stateCalculate(buoy.getbLongitude().substring(0, buoy.getbLongitude().length() - 1),
					buoy.getbLatitude().substring(0, buoy.getbLatitude().length() - 1), 
					statisticsVo.getoLongitude().substring(0, statisticsVo.getoLongitude().length()), 
					statisticsVo.getoLatitude().substring(0, statisticsVo.getoLatitude().length()));
			statisticsVo.setMoveDistance(stateCalculate.toString().length() > 6?stateCalculate.toString().substring(0,6) : stateCalculate.toString());

		}
		
		
		return statisticsVo;
	}
	@Override
	public List<Wind> selectTheLast24(String buoyId) {
		List<Wind> winds = windMapper.selectTheLast24(buoyId);
		return winds;
	}
	@Override
	public <T> List<T> selectTuBiao(T t,String service,String buoyId){
		if (service.trim().equals("wind")) {
			@SuppressWarnings("unchecked")
			//待改
			List<T> list = (List<T>) windMapper.selectTheLast24(buoyId);
			return list;
		}
		if (service.trim().equals("weather")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) weatherMapper.selectTheLast24(buoyId);
			return list;
		}
		if (service.trim().equals("waterquality")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) waterqualityMapper.selectTheLast24(buoyId);
			return list;
		}
		if (service.trim().equals("current")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) currentMapper.selectTheLast24(buoyId);
			return list;
		}
		if (service.trim().equals("wave")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) waveMapper.selectTheLast24(buoyId);
			return list;
		}
		return null;
		
		/*service = service + "Mapper";
		System.out.println(service);
		try {
			Field f = this.getClass().getDeclaredField(service);
			f.setAccessible(true);
			Field findField = ReflectionUtils.findField(this.getClass(), service);
			System.out.println(findField.getName());
			findField.setAccessible(true);
			System.out.println("aaasss");
			Method findMethod = ReflectionUtils.findMethod(findField.getClass(), "selectTheLast24", String.class);
			if (findMethod == null) {
				System.out.println("null!!");
			}
//			System.out.println(findMethod.getName());
//			Method findMethod = ReflectionUtils.findMethod(f.getClass(), "selectTheLast24", String.class);
//			Method method = f.getClass().getMethod("selectTheLast24", String.class);
////			method.setAccessible(true);
//			Object invoke = findMethod.invoke(f, "QF305");
//			System.out.println(invoke);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	@Override
	public <T> List<T> selectTuBiao2(T t,String field, String service,String buoyId,String time){
		if (service.trim().equals("wind")) {
			@SuppressWarnings("unchecked")
			//待改
			List<T> list = (List<T>) windMapper.selectTheLast24WithTime(buoyId, time);
			return list;
		}
		if (service.trim().equals("weather")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) weatherMapper.selectTheLast24WithTime(buoyId, time);
			return list;
		}
		if (service.trim().equals("waterquality")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) waterqualityMapper.selectTheLast24WithTime(buoyId, time);
			return list;
		}
		if (service.trim().equals("current")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) currentMapper.selectTheLast24WithTime(buoyId, time);
			return list;
		}
		if (service.trim().equals("wave")) {
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) waveMapper.selectTheLast24WithTime(buoyId, time);
			return list;
		}
		return null;
		
		
	}
	
	@Override
	public String[] selectTimeByDay(String date,String buoyId) {
		String[] times = buoyMapper.selectDateByLikeDay(buoyId, date);
		for (int i = 0; i < times.length; i++) {
			times[i] = StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", times[i]);
		}
		return times;
	}

	@Override
	public List<Station> selectAllStation() {
		List<Station> station = stationMapper.selectAll();
		return station;
	}
	
	

}
