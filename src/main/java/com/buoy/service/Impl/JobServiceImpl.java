package com.buoy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.controller.BaseController;
import com.buoy.entity.Alarm;
import com.buoy.entity.Alarmlog;
import com.buoy.entity.Buoy;
import com.buoy.entity.Current;
import com.buoy.entity.Station;
import com.buoy.entity.Waterquality;
import com.buoy.entity.Wave;
import com.buoy.entity.Weather;
import com.buoy.entity.Wind;
import com.buoy.mapper.AlarmMapper;
import com.buoy.mapper.AlarmlogMapper;
import com.buoy.mapper.BuoyMapper;
import com.buoy.mapper.CurrentMapper;
import com.buoy.mapper.StationMapper;
import com.buoy.mapper.WaterqualityMapper;
import com.buoy.mapper.WaveMapper;
import com.buoy.mapper.WeatherMapper;
import com.buoy.mapper.WindMapper;
import com.buoy.service.JobService;
import com.buoy.util.FbUtil;
import com.buoy.util.StringUtil;

@Service
public class JobServiceImpl implements JobService{
	protected static Logger logger = Logger.getLogger(JobServiceImpl.class);

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
	private AlarmlogMapper alarmlogMapper;
	@Autowired
	private AlarmMapper alarmMapper;
	@Autowired
	private StationMapper stationMapper;
	@Override
	public int addBuoyList(List<Buoy> buoys) {
		int result = 0;
		int return_result = 0;
		//浮标位置警报
		Alarmlog log = null;
		Alarm alarm = alarmMapper.selectByType("location");
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		for(int i = 0; i < buoys.size(); i++){
			//todo 处理插入数据结果
			//获取原始位置数据
			Buoy buoy = buoys.get(i);
			Station station = stationMapper.selectByBuoyId(buoy.getbBuoyid());
			if (alarm != null && alarm.getActive() == 1) {
				String errorData = null;
				boolean alarmResult = true;
				if (buoy.getbLongitude().equals("/") || buoy.getbLatitude().equals("/")) {
					alarmResult = false;
					errorData = "/";
				} else {
					Double stateCalculate = FbUtil.stateCalculate(station.getsLongitude(), station.getsLatitude(), 
							buoy.getbLongitude().substring(0, buoy.getbLongitude().length()-1), 
							buoy.getbLatitude().substring(0,buoy.getbLatitude().length()-1));
					alarmResult = StringUtil.checkScope(stateCalculate.toString(), alarm.getFrom(), alarm.getTo());
					errorData = stateCalculate.toString().length() > 5?stateCalculate.toString().substring(0,5) : stateCalculate.toString() ;
				}
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过海流警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", buoy.getDate()));
					log.setSummary("浮标位置异常");
					log.setDetails("浮标"+buoy.getbBuoyid()+"在"+log.getDate()+"测得距离："+errorData);
					list.add(log);
				}
			}
			result = buoyMapper.insert(buoy);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("浮标位置有"+insertResult+"条数据超过警戒值");
		}
		return return_result;
	}
	@Override
	public int addCurrentList(List<Current> currents) {
		int result = 0;
		int return_result = 0;
		Alarm alarm = alarmMapper.selectByType("speed");
		Alarmlog log = null;
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		//if (alarm != null)
		for(int i = 0; i < currents.size(); i++){
			//todo 处理插入数据结果
			Current current = currents.get(i);
			if (alarm != null && alarm.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(current.getcSpeed1(), alarm.getFrom(), alarm.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过海流警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", current.getDate()));
					log.setSummary("海流异常");
					log.setDetails("浮标"+current.getcBuoyid()+"在"+log.getDate()+"测得流速数据异常："+current.getcSpeed1());
					list.add(log);
				}
			}
			result = currentMapper.insert(current);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("海流数据"+insertResult+"条超过警戒值");
		}else {
			//logger.info("当前海流数据未超过警戒值");
		}
		return return_result;
	}
	@Override
	public int addWaterQualityList(List<Waterquality> waterQualities) {
		int result = 0;
		int return_result = 0;
		Alarmlog log = null;
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		Alarm alarmWattemp = alarmMapper.selectByType("wattemp");
		Alarm alarmSalinity = alarmMapper.selectByType("salinity");
		Alarm alarmConductivity = alarmMapper.selectByType("conductivity");
		
		for(int i = 0; i < waterQualities.size(); i++){
			//todo 处理插入数据结果
			Waterquality waterquality = waterQualities.get(i);
			
			if (alarmWattemp != null && alarmWattemp.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(waterquality.getWqWattemp(), alarmWattemp.getFrom(), alarmWattemp.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过水温警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", waterquality.getDate()));
					log.setSummary("水质数据异常");
					log.setDetails("浮标"+waterquality.getWqBuoyid()+"在"+log.getDate()+"测得水温数据异常："+waterquality.getWqWattemp());
					list.add(log);
				}
			} else if (alarmSalinity != null && alarmSalinity.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(waterquality.getWqSalinity(), alarmSalinity.getFrom(), alarmSalinity.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过盐度警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", waterquality.getDate()));
					log.setSummary("水质数据异常");
					log.setDetails("浮标"+waterquality.getWqBuoyid()+"在"+log.getDate()+"测得盐度数据异常："+waterquality.getWqSalinity());
					list.add(log);
				}
			}else if (alarmConductivity != null && alarmConductivity.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(waterquality.getWqConductivity(), alarmConductivity.getFrom(), alarmConductivity.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过电导率警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", waterquality.getDate()));
					log.setSummary("水质数据异常");
					log.setDetails("浮标"+waterquality.getWqBuoyid()+"在"+log.getDate()+"测得电导率数据异常："+waterquality.getWqConductivity());
					list.add(log);
				}
			}
			
			result = waterqualityMapper.insert(waterquality);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("水质数据"+insertResult+"条超过警戒值");
		}else {
			//logger.info("当前水质数据未超过警戒值");
		}
		return return_result;
	}
	@Override
	public int addWaveList(List<Wave> waves) {
		int result = 0;
		int return_result = 0;
		
		Alarmlog log = null;
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		Alarm alarmHighMax = alarmMapper.selectByType("high_max");
		Alarm alarmHighEffective = alarmMapper.selectByType("high_effective");
		Alarm alarmCycleEffective = alarmMapper.selectByType("cycle_effective");
		
		for(int i = 0; i < waves.size(); i++){
			//todo 处理插入数据结果
			Wave wave = waves.get(i);
			
			if (alarmHighMax != null && alarmHighMax.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wave.getwHighMax(), alarmHighMax.getFrom(), alarmHighMax.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过最大波高警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wave.getDate()));
					log.setSummary("波数据异常");
					log.setDetails("浮标"+wave.getwBuoyid()+"在"+log.getDate()+"测得最大波高数据异常："+wave.getwHighMax());
					list.add(log);
				}
			} else if (alarmHighEffective != null && alarmHighEffective.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wave.getwHighEffective(), alarmHighEffective.getFrom(), alarmHighEffective.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过有效波高警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wave.getDate()));
					log.setSummary("波数据异常");
					log.setDetails("浮标"+wave.getwBuoyid()+"在"+log.getDate()+"测得有效波高数据异常："+wave.getwHighEffective());
					list.add(log);
				}
			}else if (alarmCycleEffective != null && alarmCycleEffective.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wave.getwCycleEffective(), alarmCycleEffective.getFrom(), alarmCycleEffective.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过有效波周期警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wave.getDate()));
					log.setSummary("波数据异常");
					log.setDetails("浮标"+wave.getwBuoyid()+"在"+log.getDate()+"测得有效波周期数据异常："+wave.getwCycleEffective());
					list.add(log);
				}
			}
			
			result = waveMapper.insert(wave);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("波数据"+insertResult+"条超过警戒值");
		}else {
			//logger.info("当前波数据未超过警戒值");
		}
		return return_result;
	}
	@Override
	public int addWeatherList(List<Weather> weathers) {
		int result = 0;
		int return_result = 0;
		Alarmlog log = null;
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		Alarm alarmAirpre = alarmMapper.selectByType("airpre");
		Alarm alarmAirtemp = alarmMapper.selectByType("airtemp");
		Alarm alarmOppohumi = alarmMapper.selectByType("oppohumi");
		for(int i = 0; i < weathers.size(); i++){
			//todo 处理插入数据结果
			Weather weather = weathers.get(i);
			if (alarmAirpre != null && alarmAirpre.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(weather.getwAirpre(), alarmAirpre.getFrom(), alarmAirpre.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过气压警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", weather.getDate()));
					log.setSummary("天气数据异常");
					log.setDetails("浮标"+weather.getwBuoyid()+"在"+log.getDate()+"测得气压数据异常："+weather.getwAirpre());
					list.add(log);
				}
			} else if (alarmAirtemp != null && alarmAirtemp.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(weather.getwAirtemp(), alarmAirtemp.getFrom(), alarmAirtemp.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过气温警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", weather.getDate()));
					log.setSummary("天气数据异常");
					log.setDetails("浮标"+weather.getwBuoyid()+"在"+log.getDate()+"测得气温数据异常："+weather.getwAirtemp());
					list.add(log);
				}
			}else if (alarmOppohumi != null && alarmOppohumi.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(weather.getwOppohumi(), alarmOppohumi.getFrom(), alarmOppohumi.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过湿度警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", weather.getDate()));
					log.setSummary("天气数据异常");
					log.setDetails("浮标"+weather.getwBuoyid()+"在"+log.getDate()+"测得湿度数据异常："+weather.getwOppohumi());
					list.add(log);
				}
			}
			
			result = weatherMapper.insert(weather);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("天气数据"+insertResult+"条超过警戒值");
		}else {
			//logger.info("当前天气数据未超过警戒值");
		}
		return return_result;
	}
	@Override
	public int addWindList(List<Wind> winds) {
		int result = 0;
		int return_result = 0;
		
		Alarmlog log = null;
		List<Alarmlog> list = new ArrayList<Alarmlog>();
		Alarm alarmSpeedMax = alarmMapper.selectByType("speed_max");
		Alarm alarmSpeedJi = alarmMapper.selectByType("speed_ji");
		Alarm alarmSpeedTen = alarmMapper.selectByType("speed_ten");
		
		for(int i = 0; i < winds.size(); i++){
			//todo 处理插入数据结果
			Wind wind = winds.get(i);
			if (alarmSpeedMax != null && alarmSpeedMax.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wind.getWindSpeedMax(), alarmSpeedMax.getFrom(), alarmSpeedMax.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过最大风速警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wind.getDate()));
					log.setSummary("风数据异常");
					log.setDetails("浮标"+wind.getWindBuoyid()+"在"+log.getDate()+"测得最大风速数据异常："+wind.getWindSpeedMax());
					list.add(log);
				}
			} else if (alarmSpeedJi != null && alarmSpeedJi.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wind.getWindSpeedJi(), alarmSpeedJi.getFrom(), alarmSpeedJi.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过极大风速警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wind.getDate()));
					log.setSummary("风数据异常");
					log.setDetails("浮标"+wind.getWindBuoyid()+"在"+log.getDate()+"测得极大风速数据异常："+wind.getWindSpeedJi());
					list.add(log);
				}
			}else if (alarmSpeedTen != null && alarmSpeedTen.getActive() == 1) {
				boolean alarmResult = StringUtil.checkScope(wind.getWindSpeedTen(), alarmSpeedTen.getFrom(), alarmSpeedTen.getTo());
				if (!alarmResult) {
					//记录报警日志
					//logger.info("有超过平均风速警戒值数据");
					log = new Alarmlog();
					log.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", wind.getDate()));
					log.setSummary("风数据异常");
					log.setDetails("浮标"+wind.getWindBuoyid()+"在"+log.getDate()+"测得平均风速数据异常："+wind.getWindSpeedTen());
					list.add(log);
				}
			}
			
			result = windMapper.insert(wind);
			return_result += result;
		}
		if (list.size() > 0) {
			int insertResult = alarmlogMapper.insertBatch(list);
			logger.info("风数据"+insertResult+"条超过警戒值");
		}else {
			//logger.info("当前波数据未超过警戒值");
		}
		return return_result;
	}
	
}
