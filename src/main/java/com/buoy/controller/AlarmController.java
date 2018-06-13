package com.buoy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.buoy.entity.Alarm;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.AlarmService;
import com.buoy.util.Constant;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
/**
 * 报警设置控制类
 * @author hongwu
 *
 */
@Controller
@RequestMapping("/alarm")
public class AlarmController extends BaseController {
	
	@Autowired
	private AlarmService alarmService;
	@RequiresAuthentication
	@RequiresPermissions("alarm")
	@RequestMapping("")
	public String view () {
		return "/alarm";
	}
	@RequiresAuthentication
	@RequiresPermissions("alarm")
	@RequestMapping("/view")
	public @ResponseBody void dataView () throws IOException {
		List<Alarm> alarms = alarmService.selectAll(); 
		ResultInfo result = null;
		if (alarms == null || alarms.size() <=0) {
			result = new ResultInfo(Constant.TYPE_RESULT_FAIL, 0, "获取报警设置信息失败");
		} else {
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功获取"+alarms.size()+"条数据");
			Map<String, Object> map = new HashMap<>();
			map.put("alarms", alarms);
			result.setSysdata(map);
		}
		String data = JSON.toJSONString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		out.print(data); 
		out.flush();
	}
	@RequiresAuthentication
	@RequiresPermissions("alarm")
	@RequestMapping("/save")
	public @ResponseBody void save(String data) throws ExceptionResultInfo, IOException {
		
		String[] arrays = data.split("\\|");
		Alarm alarm = null;
		List<Alarm> alarms = new ArrayList<>();
		for (String str:arrays) {
			alarm = new Alarm();
			String obj[] = str.split(",");
//			System.out.println();
			alarm.setDate(StringUtil.getNowTime("yyyy-MM-dd HH:mm"));
			if (obj[2] != null) {
				alarm.setActive(Integer.parseInt(obj[2]));
			}
			if (obj[0] == null || obj[0].trim().equals("")) {
				alarm.setFrom(null);
			}else {
				//验证数字格式  开启报警的情况下如果输入的不是数字 则抛出异常
				if(!StringUtil.checkNum(obj[0])) {
					if (alarm.getActive() == 1) {
						throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "请输入正确的数字格式!");
					}else {
						alarm.setFrom("");
					}
				}else {
					alarm.setFrom(obj[0]);
				}
				
			}
			if (obj[1] == null || obj[1].trim().equals("")) {
				alarm.setTo(null);
			}else {
				//验证数字格式
				if(!StringUtil.checkNum(obj[1])) {
					if (alarm.getActive() == 1) {
						throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "请输入正确的数字格式!");
					}else {
						alarm.setTo("");
					}
				}else {
					alarm.setTo(obj[1]);
				}
				
			}
			alarm.setType(obj[3]);
			alarms.add(alarm);
		}
		ResultInfo result = null;
		int r = alarmService.updateList(alarms);
		if (r != 13) {
			result = new ResultInfo(Constant.TYPE_RESULT_WARN, 0, "保存成功"+r+"条，失败"+(14-r)+"条");
		}else {
			result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "保存成功");
		}
		String d = JSON.toJSONString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		out.print(d); 
		out.flush();
	}
	
}
