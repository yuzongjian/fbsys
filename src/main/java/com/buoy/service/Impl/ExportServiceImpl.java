package com.buoy.service.Impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.StatisticsVo;
import com.buoy.mapper.AlarmlogMapper;
import com.buoy.mapper.BuoyMapper;
import com.buoy.mapper.BuoylogMapper;
import com.buoy.mapper.CurrentMapper;
import com.buoy.mapper.ExportMapper;
import com.buoy.mapper.WaterqualityMapper;
import com.buoy.mapper.WaveMapper;
import com.buoy.mapper.WeatherMapper;
import com.buoy.mapper.WindMapper;
import com.buoy.service.ExportService;
import com.buoy.util.ExcelExportSXXSSF;
import com.buoy.util.StringUtil;
@Service
public class ExportServiceImpl implements ExportService{
//	@Autowired
//	private BuoyMapper buoyMapper;
//	@Autowired
//	private CurrentMapper currentMapper;
//	@Autowired
//	private WaterqualityMapper waterqualityMapper;
//	@Autowired
//	private WaveMapper waveMapper;
//	@Autowired
//	private WeatherMapper weatherMapper;
//	@Autowired
//	private WindMapper windMapper;
	
	@Autowired
	private ExportMapper exportMapper;
	@Autowired
	private AlarmlogMapper alarmlogMapper;
	@Autowired
	private BuoylogMapper buoylogMapper;
	
	
	public List<StatisticsVo> exportData(String data[],String fromDay,String toDay) {
		List<String> params = new ArrayList<>();
		params = Arrays.asList(data);
		System.out.println(fromDay+"--="+toDay);
		List<StatisticsVo> datas = exportMapper.selectToExport(fromDay, toDay, params);
		System.out.println("////"+datas.size());
		return datas;

	}
	public List<StatisticsVo> exportByDay(String data[],String day) {
		day = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", day);
		String fromDay = day;
		String toDay = day;
//		String[] paramsNames = StringUtil.getParamsName(params);
		List<String> params = new ArrayList<>();
		params = Arrays.asList(data);
		List<StatisticsVo> datas = exportMapper.selectToExport(fromDay, toDay, params);
		return datas;
	
	}
	public List<StatisticsVo> exportByYear(String data[],String year) {
		List<String> params = new ArrayList<>();
		params = Arrays.asList(data);
		List<StatisticsVo> datas = exportMapper.selectToExportByYear(year, params);
		return datas;
	
	}
	
}
