package com.buoy.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.buoy.entity.Alarmlog;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.AlarmService;
import com.buoy.service.LastTimeService;
import com.buoy.service.LogService;
import com.buoy.service.StatisticsService;
import com.buoy.service.Impl.AlarmServiceImpl;
import com.buoy.service.Impl.LogServiceImpl;
import com.buoy.util.Constant;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
/**
 * 统计查询控制类
 * @author hongwu
 *
 */
@RequestMapping("/statistics")
@Controller
public class StatisticsController extends BaseController{
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private LastTimeService lastTimeService;
	@Autowired
	private LogService logServiceImpl;
	
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("")
	public String view(Model model ) throws ExceptionResultInfo {
		StatisticsVo statistics = statisticsService.selectTheLast();
		//System.out.println(statistics);
		model.addAttribute("statistics", statistics);
//		List<Wind> winds = statisticsService.selectTheLast24("QF305");
//		for(Wind w:winds) {
//			System.out.println(w);
//		}
		return "/statistics";
	}
	
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("/refresh")
	public void refreshView(Model model ) throws ExceptionResultInfo, IOException {
		StatisticsVo statistics = statisticsService.selectTheLast();
		model.addAttribute("statistics", statistics);
		Map<String, Object> map = new HashMap<>();
		ResultInfo r = null;
		if (statistics != null ) {
			map.put("statistics", statistics);
			r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取数据成功!");
			r.setSysdata(map);
		}else {
			r = new ResultInfo(Constant.TYPE_RESULT_FAIL,0,"数据获取失败!");
		}
		String data = JSON.toJSONString(r);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		
		out.print(data); //将json数据写入流中
		out.flush();
	}
	
	

	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping(value="/json/tubiao")
	public @ResponseBody void tuBiao(String field,String table,String buoyId,String date) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ExceptionResultInfo {
		//System.out.println(field+"   "+table);
		if (date == null || date.trim().equals("")) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "未找到数据");
		}
		date = StringUtil.changeFormat("yyyy-MM-dd HH:mm", "yyMMddHHmm", date);
		
		StringBuilder str = new StringBuilder();
		str.append(table.substring(0, 1).toUpperCase()).append(table.substring(1));
		String s = str.toString();
		Class<?> clazz = Class.forName("com.buoy.entity."+s);
		Object obj = clazz.newInstance();
		
		String filedMethodName = StringUtil.changeToGetXXX(field);
		String dateMethodName = StringUtil.changeToGetXXX("date");
		
		//System.out.println(filedMethodName);
		List<?> list = statisticsService.selectTuBiao2(obj, field, table, buoyId, date);
		//System.out.println(list.size());
		StringBuilder parameter = new StringBuilder();
		StringBuilder time = new StringBuilder();
		for(int i = list.size()-1; i >= 0; i--) {
			obj = list.get(i);
			Method method1 = obj.getClass().getMethod(filedMethodName);
			Method method2= obj.getClass().getMethod(dateMethodName);
			String result1 = (String) method1.invoke(obj, null);
			String result2 = (String) method2.invoke(obj, null);
			
			//过滤非0或者'/'
			if (null == result1 || !StringUtil.isNumeric(result1)) {
				parameter.append("0").append(",");
			} else {
				parameter.append(result1).append(",");
			}
			
			time.append(StringUtil.changeFormat(result2)).append(",");
			//System.out.println(result2);
		}
		Map<String, Object> m = new HashMap<>();
		ResultInfo r = null;
		if (list.size() > 0 ) {
			String p = parameter.toString().substring(0, parameter.length()-1);
			String t = time.toString().substring(0,time.length()-1);
			m.put("speed", p);
			m.put("time", t);
			r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取数据成功!");
		}else {
			r = new ResultInfo(Constant.TYPE_RESULT_FAIL,0,"未查到相关数据");
		}
		
		
		r.setSysdata(m);
//		m.put("风速", "1,2,3,2,3,4,3.5,2.3,3,4.5,1.5,1.8,3.3,4,5,3.4,2.2,2.2,4.5,2.6,5.4,3.4,3.4,4.8");
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
		//System.out.println("aaa");
	}
	
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping(value="/json/time",produces = "text/html;charset=UTF-8")
	public @ResponseBody void getTimeByday(String date,String buoy) throws JsonGenerationException, JsonMappingException, IOException, ExceptionResultInfo {
		logger.info("获取"+date+"的时间点!");
		if (date == null || date.trim().equals("")) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_WARN, "不存在时间数据");
		}
 		String oldDateFormat = date;
		date = StringUtil.changeFormat("yy-MM-dd", "yyMMdd", date);
		//System.out.println(date);
		
		String[] times = statisticsService.selectTimeByDay(date, buoy);
		if (times.length <=0 ) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, oldDateFormat+"不存在有数据的时间点");
		}
//		for (String s:times) {
//			System.out.println(s);
//		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("time", times);
		
		ResultInfo r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "获取时间点成功!");
		r.setSysdata(map);
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("/json/view")
	public @ResponseBody void viewByDate(String date,String buoyId) throws IOException, ExceptionResultInfo {
		logger.info("获取浮标"+buoyId+"在"+date+"的数据");
		String time = null;
		if (date == null || date.trim().equals("")) {
			String d = lastTimeService.selectByBuoyName("buoy");
			time = lastTimeService.selectBuoyLastTime(d, buoyId);
		}
		if (date != null && !date.trim().equals("")) {
			date = StringUtil.changeFormat("yyyy-MM-dd HH:mm", "yyMMddHHmm", date);
		}else if (time != null) {
			date = time;
		}else {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "未找到数据!");
			
		}
		
		//System.out.println(date);
		
//		String[] times = statisticsService.selectTimeByDay(date, buoyId);
//		for (String s:times) {
//			System.out.println(s);
//		}
		StatisticsVo statistics = statisticsService.selectTheByDate(buoyId, date);
		if (statistics == null) 
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "不存在"+buoyId+"在"+date+"的数据");
		Map<String, Object> map = new HashMap<>();
		map.put("statistics", statistics);
		ResultInfo r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功获取"+buoyId+"在"+date+"的数据");
		r.setSysdata(map);
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("/json/station")
	public @ResponseBody void viewStation() throws IOException, ExceptionResultInfo {
		logger.info("获取所有站位");
		Map<String, Object> map = new HashMap<>();
		ResultInfo r =  null;
		List<Station> station = statisticsService.selectAllStation();
		if (station.size() <= 0) {
			r = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "获取站位信息失败");
		}else {
			r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功获取站位信息");
			map.put("stations", station);
			r.setSysdata(map);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("/json/alarmlog")
	public @ResponseBody void getAlarmLog() throws IOException, ExceptionResultInfo {
		logger.info("获取报警信息");
		List<Alarmlog> alarms = logServiceImpl.getAlarmLogByActive();
		Map<String, Object> map = new HashMap<>();
		ResultInfo r =  null;
		System.out.println(alarms.size());
		if (alarms.size() <= 0) {
			r = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "未查询到警报信息");
		}else {
			r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功获取警报信息");
			map.put("logs", alarms);
			r.setSysdata(map);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("statistics")
	@RequestMapping("/json/closealarm")
	public @ResponseBody void closeAlarm(Integer id) throws IOException, ExceptionResultInfo {
		logger.info("关闭报警信息");
		int i = logServiceImpl.updateAlarmLog(id);
		ResultInfo r =  null;
		if (i <= 0) {
			r = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "关闭警报失败");
		}else {
			r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功获取警报信息");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
	}
}
