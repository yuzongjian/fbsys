package com.buoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buoy.entity.Station;
import com.buoy.entity.User;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.BuoyService;
import com.buoy.util.Constant;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
/**
 * 浮标管理控制类
 * @author hongwu
 *
 */
@Controller
@RequestMapping("/buoy")
public class BuoyController extends BaseController{
	@Autowired
	private BuoyService buoyService;
	
	@RequiresAuthentication
	@RequiresPermissions("buoy")
	@RequestMapping("")
	public String buoyManagement() {
		
		return "/float";
	}
	@RequestMapping("/getall")
	public @ResponseBody void getAllBuoy() throws ExceptionResultInfo, JsonGenerationException, JsonMappingException, IOException {
		List<Station> stations = buoyService.selectAll();
		if (stations == null || stations.size() < 0) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "获取站位信息失败!");
		}
		ResultInfo result = null;
		if (stations.size() == 0) {
			result = new ResultInfo(Constant.TYPE_RESULT_WARN, 0, "未获取到站位信息!");
		}else {
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "获取到"+stations.size()+"个站位信息!");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("stations", stations);
		result.setSysdata(map);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		out.print(data); 
		out.flush();
		
	}
	@RequiresAuthentication
	@RequiresPermissions("buoy")
	@RequestMapping("/saveorupdate")
	public @ResponseBody void saveOrUpdateBuoy(String data,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		User u = (User) request.getSession().getAttribute("session_user");
		logger.info("浮标插入与更新...");
		ResultInfo result = null;
		if (data == null) {
			logger.error("信息获取异常,信息插入或更新失败");
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "信息获取异常,保存失败");
		}else {
			//解析字符串
			String[] arrays = data.split("\\|");
			if (arrays == null || arrays.length <= 0) {
				logger.error("字符串解析异常,信息插入或更新失败");
				result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "信息获取异常,保存失败");
			}else {
				/*for (String ss:arrays) {
					System.out.println(ss.toString());
				}*/
				List<Station> stations = new ArrayList<>();
				for (String s: arrays) {
					String[] obj = s.split(",");
					if (obj == null || obj.length != 8) {
						logger.error("字符串解析异常,信息插入或更新失败");
						result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "信息获取异常,保存失败");
					}else {
						Station station = new Station();
						if (obj[2] !=null && !"".equals(obj[2].trim())) {
							continue; 
						}
						if(!"".equals(obj[0])) {
							station.setsActive(Integer.parseInt(obj[0]));
						}else {
							station.setsId(null);
						}
						if(!"".equals(obj[1])) {
							station.setsId(Integer.parseInt(obj[1]));
						}else {
							station.setsId(null);
						}
						station.setDate(StringUtil.getNowTime("yyMMddHHmm"));
						if (obj[3] !=null && !"".equals(obj[3].trim())) {
							station.setsDescribe(obj[3]);
						}else {
							station.setsDescribe(null);
						}
						station.setsStation(obj[4]);
						station.setsBuoyid(obj[5]);
						station.setsLongitude(obj[6]);
						station.setsLatitude(obj[7]);
						stations.add(station);
					}
					
			}
			Map<String, Object> map = buoyService.updateStation(stations,u.getUsername());
			logger.info("成功更新"+map.get("update")+"条，插入"+map.get("insert")+"条，失败"+map.get("fail")+"条");
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功更新"+map.get("update")+"条，插入"+map.get("insert")+"条，失败"+map.get("fail")+"条");


		}
		//返回结果
		//下面代码段可以在配置里全局设置。。。待优化
		ObjectMapper objectMapper = new ObjectMapper();
		String d = objectMapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(d); //将json数据写入流中
		out.flush();
		}
	}
	@RequiresAuthentication
	@RequiresPermissions("buoy")
	@RequestMapping("/updatebuoy")
	public @ResponseBody void updateBuoy(String stationid,
										String buoyid,
										String longitude,
										String latitude,
										String describe) throws JsonGenerationException, JsonMappingException, IOException {
		User u = (User) request.getSession().getAttribute("session_user");
//		System.out.println();
		Station station = buoyService.selectByStation(stationid);
		logger.info("准备更新"+stationid+"号站位信息");
		ResultInfo result = null;
		if (station == null) {
			logger.error(stationid+"号站位不存在,更新失败");
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "该站位号不存在");
			//System.out.println("出错");
		}
		station.setDate(StringUtil.getNowTime("yyMMddHHmm"));
		station.setsBuoyid(buoyid);
		station.setsDescribe(describe);
		station.setsLatitude(latitude);
		station.setsLongitude(longitude);
		int i = buoyService.updateStation(station,u.getUsername());
		if (i == 2) {
			logger.info("更新"+stationid+"号站位成功");
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "更新成功!");
		}else {
			logger.error("更新"+stationid+"号站位失败");
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "更新失败!");
		}
//		Map<String, Object> m = new HashMap<>();
//		m.put("", p);/
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
		
	}
}
