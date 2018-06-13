package com.buoy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Station;
import com.buoy.entity.VisualizationVo;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.mapper.CurrentMapper;
import com.buoy.mapper.StationMapper;
import com.buoy.mapper.WaterqualityMapper;
import com.buoy.mapper.WaveMapper;
import com.buoy.mapper.WeatherMapper;
import com.buoy.mapper.WindMapper;
import com.buoy.service.VisualizationService;
import com.buoy.util.Constant;
@Service
public class VisualizationServiceImpl implements VisualizationService{
	@Autowired
	private StationMapper stationMapper;
	@Autowired
	private WindMapper windMapper;
	@Autowired
	private WeatherMapper weatherMapper;
	@Autowired
	private CurrentMapper currentMapper;
	@Autowired
	private WaterqualityMapper waterqualityMapper;
	@Autowired
	private WaveMapper waveMapper;
	protected static Logger logger = Logger.getLogger(VisualizationServiceImpl.class);
	@Override
	public VisualizationVo selectByCondition(String mapper,String fromDay,String toDay) throws ExceptionResultInfo{
		VisualizationVo vvo = new VisualizationVo();
		List<Station> stations = stationMapper.selectAll();
//		for(Station s:stations) {
//			System.out.println(s.getsBuoyid());
//		}
		List<String> buoys = new ArrayList<>();
		List<String> buoyswithDate = new ArrayList<>();
		for (int i = 0; i < stations.size(); i++) {
			buoys.add(stations.get(i).getsBuoyid());
		}
		logger.info("获取所有浮标号...");
		//vvo.setBuoys(buoys);
		List<List<?>> result = new ArrayList<>();
		if (mapper.trim().equals("wind")) {
			for (int i = 0; i < buoys.size(); i++) {
				
				List<?> list =windMapper.selectBetweenDay(buoys.get(i),fromDay,toDay);
//				if (list.size() <= 0) {
//					logger.error("数据获取失败,"+fromDay+"到"+toDay+"不存在相关数据");
//					throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"该时间段数据不存在！");
//					
//				}
				if (list.size() != 0) {
					result.add(list);
					buoyswithDate.add(buoys.get(i));
				}
			}
			
		}
		if (mapper.trim().equals("weather")) {
			for (int i = 0; i < buoys.size(); i++) {
				List<?> list =weatherMapper.selectBetweenDay(buoys.get(i),fromDay,toDay);
//				if (list.size() <= 0) {
//					logger.error("数据获取失败,"+fromDay+"到"+toDay+"不存在相关数据");
//					throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"该时间段数据不存在！");
//				}
				if (list.size() != 0) {
					result.add(list);
					buoyswithDate.add(buoys.get(i));
				}
			}
		}
		if (mapper.trim().equals("wave")) {
			for (int i = 0; i < buoys.size(); i++) {
				List<?> list =waveMapper.selectBetweenDay(buoys.get(i),fromDay,toDay);
//				if (list.size() <= 0) {
//					logger.error("数据获取失败,"+fromDay+"到"+toDay+"不存在相关数据");
//					throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"该时间段数据不存在！");
//				}
				if (list.size() != 0) {
					result.add(list);
					buoyswithDate.add(buoys.get(i));
				}
			}
		}
		if (mapper.trim().equals("current")) {
			for (int i = 0; i < buoys.size(); i++) {
				List<?> list =currentMapper.selectBetweenDay(buoys.get(i),fromDay,toDay);
//				if (list.size() <= 0) {
//					logger.error("数据获取失败,"+fromDay+"到"+toDay+"不存在相关数据");
//					throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"该时间段数据不存在！");
//				}
				if (list.size() != 0) {
					result.add(list);
					buoyswithDate.add(buoys.get(i));
				}
			}
		}
		if (mapper.trim().equals("waterquality")) {
			for (int i = 0; i < buoys.size(); i++) {
				List<?> list =waterqualityMapper.selectBetweenDay(buoys.get(i),fromDay,toDay);
//				if (list.size() <= 0) {
//					logger.error("数据获取失败,"+fromDay+"到"+toDay+"不存在相关数据");
//					throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"该时间段数据不存在！");
//				}
				if (list.size() != 0) {
					result.add(list);
					buoyswithDate.add(buoys.get(i));
				}
			}
		}
		if (fromDay !=null && toDay !=null) {
			logger.info("数据"+fromDay+"到"+toDay+"获取成功!");
		}else{
			logger.info("数据获取成功!");
		}
		vvo.setList(result);
		vvo.setBuoys(buoyswithDate);
		return vvo;
	}
}
