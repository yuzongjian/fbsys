package com.buoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.buoy.entity.Alarmlog;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.service.LastTimeService;
import com.buoy.service.MapService;
import com.buoy.service.StatisticsService;
import com.buoy.util.Constant;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
/**
 * 地图管理控制类
 * @author hongwu
 *
 */
@Controller
@RequestMapping("/map")
public class MapController extends BaseController{
	@Autowired
	private MapService mapServiceImpl;
	@Autowired
	private LastTimeService lastTimeService;
	@Autowired
	private StatisticsService statisticsService;
	
	@RequiresAuthentication
	@RequiresPermissions("map")
	@RequestMapping("")
	public String mapView() {
//		List<StatisticsVo> buoys = mapServiceImpl.selectByLastTime();
//		for (StatisticsVo buoy:buoys) {
//			System.out.println(buoy);
//		}
		return "/map";
	}
	@RequiresAuthentication
	@RequiresPermissions("map")
	@RequestMapping("/getbuoys")
	public @ResponseBody void getBuoy() throws IOException {
		String time = lastTimeService.selectByBuoyName("buoy");
		List<Station> stations = statisticsService.selectAllStation();
		Map<String, Object> map = mapServiceImpl.selectByLastTime(time,stations);
//		List<StatisticsVo> buoys = mapServiceImpl.selectByLastTime(time,stations);
		List<StatisticsVo> buoys = (List<StatisticsVo>) map.get("buoys");
		for (StatisticsVo buoy:buoys) {
			buoy.setTime(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", buoy.getTime()));
		}
		map.put("buoys", buoys);
		
		List<Station> noDataBuoys = (List<Station>) map.get("nodatabuoys");
		for (Station s:noDataBuoys) {
			s.setDate(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", s.getDate()));
		}
		map.put("nodatabuoys", noDataBuoys);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("buoys", buoys);
		ResultInfo result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取浮标日志成功!");
		result.setSysdata(map);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		String data = JSON.toJSONString(result);
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("map")
	@RequestMapping("/getlogs")
	public @ResponseBody void getLog(String buoy,String day) {
		//判断
		List<Alarmlog> logs = mapServiceImpl.selectLogByBuoyIdAndDate(buoy, day);
		return ;
	}
	/**
	 * 获取上一个或者下一个时间点的数据
	 * @param buoy
	 * @param time
	 * @param type
	 * @throws IOException 
	 */
	@RequiresAuthentication
	@RequiresPermissions("map")
	@RequestMapping("/getortherdata")
	public @ResponseBody void getPreOrNext(String buoy,String time,int type) throws IOException {
		//判断
		if (time == null) {
			
		}else {
			time = StringUtil.changeFormat("yyyy-MM-dd HH:mm", "yyMMddHHmm", time);
		}
		StatisticsVo buoy_ = mapServiceImpl.getPreOrNext(buoy, time, type);
		ResultInfo result = null; 
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (buoy_ == null) {
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL,0,"获取数据失败!");
		}else {
			buoy_.setTime(StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", buoy_.getTime()));
			map.put("buoys", buoy_);
			result= new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取浮标日志成功!");
			result.setSysdata(map);
		}
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html"); 
		String data = JSON.toJSONString(result);
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
		
	}
}
