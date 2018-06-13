package com.buoy.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.util.GenericSignature.ArrayTypeSignature;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.buoy.entity.StatisticsVo;
import com.buoy.entity.VisualizationVo;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.ExportService;
import com.buoy.service.VisualizationService;
import com.buoy.util.Constant;
import com.buoy.util.ExcelExportSXXSSF;
import com.buoy.util.ExcelUtil;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
import com.hxtt.a.a;
/**
 * 可视化控制类
 * @author hongwu
 *
 */
@Controller
@RequestMapping("/visualization")
public class VisualizationController extends BaseController {
	@Autowired
	private VisualizationService visualizationService;
	@Autowired
	private ExportService exportService;
	
	@RequiresAuthentication
	@RequiresPermissions("visualization")
	@RequestMapping("")
	public String visualization(Model model ) {
		
		return "/visualization";
	}
	
	@RequiresAuthentication
	@RequiresPermissions("visualization")
	@RequestMapping("/show")
	public @ResponseBody void Show(String field,String table,String fromDay,String toDay)throws Exception {
		//System.out.println("-"+field+"-"+table+"-"+fromDay+"-"+toDay);
		
		
		if (fromDay != null && toDay !=null) {
			logger.info("获取"+fromDay+"到"+toDay+"的数据!");
			if (fromDay.compareTo(toDay) > 0) {
				throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"起始日期不能大于结束日期!!!");
			}
			fromDay = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", fromDay);
			toDay = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", toDay);
		}
		
		StringBuilder str = new StringBuilder();
		str.append(table.substring(0, 1).toUpperCase()).append(table.substring(1));
		String s = str.toString();
		Class<?> clazz = Class.forName("com.buoy.entity."+s);
		Object obj = clazz.newInstance();
		
		String filedMethodName = StringUtil.changeToGetXXX(field);
		String dateMethodName = StringUtil.changeToGetXXX("date");
		VisualizationVo vvo = visualizationService.selectByCondition(table,fromDay,toDay);
		List<List<?>> list = vvo.getList();
		String[] arrays = new String[list.size()];
		StringBuilder time = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			List<?> result = (List<?>) list.get(i);
			//System.out.println("="+result.size());
			
			StringBuilder parameter = new StringBuilder();
			
			for(int j = result.size()-1; j >= 0; j--) {
				obj = result.get(j);
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
				if (i==0) {
					time.append(StringUtil.changeFormat(result2)).append(",");
				}
				//System.out.print(result2+" ");
			}
			String p = parameter.toString().substring(0, parameter.length()-1);
			//System.out.println(p);
			arrays[i] = p;
		}
		String t = time.toString().substring(0,time.length()-1);
		
		//构造输出结果集
		Map<String, Object> map = new HashMap<>();
		map.put("buoys", vvo.getBuoys());
		map.put("data", arrays);
		map.put("time", t);
		
		ResultInfo r = new ResultInfo(Constant.TYPE_RESULT_SUCCESS, 0, "成功!");
		r.setSysdata(map);
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(r);
		//输出json
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		out.flush();
		
	}
	/*@RequestMapping("/export")
	public String ExportData(String data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//		List<Map<String, Object>> list = null;  
		System.out.println(data);
		String fileName="excelExprot";
//        JSONArray jsonArray = JSONArray.parseArray(data);
//        Object[] array = jsonArray.toArray();
        String[] params = data.split(",");
//        for (int i = 0; i < array.length; i++) {
//        	params[i] = array[i].toString();
//        }
        
		System.out.println("进来了");
		List<Map<String, Object>> exportData = exportService.exportData(params);
		String[] paramsNames = StringUtil.getParamsName(params);
		
		System.out.println(exportData.size()+"---"+params.length+"--"+paramsNames.length);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(exportData,params,paramsNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
//		for (String name: paramsNames) {
//			System.out.println(name);
//		}
        return null;
	}*/
	@RequiresAuthentication
	@RequiresPermissions("export")
	@RequestMapping("/export")
	public String ExportData(String data,String fromDay,String toDay) throws Exception {
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
//		List<String> names = new ArrayList<>();
//		names.add("date");
//		names.add("b_buoyid");
//		List<String> reflect = new ArrayList<>();
		
		
		String[] params = data.split(",");
		List<StatisticsVo> datas = exportService.exportData(params,fromDay,toDay);
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}
	
	/*@RequestMapping("/exportbyday")
	public String ExportByDay(String data,String day,HttpServletResponse response) throws Exception {
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
//		List<String> names = new ArrayList<>();
//		names.add("date");
//		names.add("b_buoyid");
//		List<String> reflect = new ArrayList<>();
		
		
		String[] params = data.split(",");
		List<StatisticsVo> datas = exportService.exportByDay(params, day);
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}*/
	
	/*@RequestMapping("/exportbyyear")
	public String ExportByYear(String data,String year,HttpServletResponse response) throws Exception {
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		
		String[] params = data.split(",");
		year = year.substring(2);
		List<StatisticsVo> datas = exportService.exportByYear(params, year);
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}*/
	
	/*@RequestMapping("/exportbymonth")
	public String ExportByMonth(String data,String year,String month,HttpServletResponse response) throws Exception {
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		
		String[] params = data.split(",");
		if (month.length() ==1) {
			month = "0"+month;
		}
		year = year.substring(2) + month;
		List<StatisticsVo> datas = exportService.exportByYear(params, year);
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}*/
	
	/*@RequestMapping("/exportbyquarter")
	public String ExportByQuarter(String data,String param,HttpServletResponse response) throws Exception {
		System.out.println("进来！！！！");
		int q = Integer.parseInt(param);
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		String year = StringUtil.getNowTime("yyyyMMddHHmm").substring(0, 4);
		String[] params = data.split(",");
		String fromDay = null;
		String toDay = null;
		if(q==1) {
			fromDay = year + "-01-01";
			toDay = year + "-03-31";
		}else if(q==2) {
			fromDay = year + "-04-01";
			toDay = year + "-06-30";
		}else if(q==3) {
			fromDay = year + "-07-01";
			toDay = year + "-09-30";
		}else if(q==4) {
			fromDay = year + "-10-01";
			toDay = year + "-12-31";
		}
		
		
		
		
		List<StatisticsVo> datas = exportService.exportData(params, fromDay, toDay);
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}*/
	@RequiresAuthentication
	@RequiresPermissions("export")
	@RequestMapping("/exportdatas")
	public String ExportData(String data,String day1,String day2,Integer param,HttpServletResponse response) throws Exception {
		String[] params = data.split(",");
		List<StatisticsVo> datas = null;
		//int flag = 0;
		if (param == null || "".equals(params)) {
			System.out.println("空");
		}else {
			//flag = Integer.parseInt(param);
		}
		if(param == 1) { 
			 //按日期范围导出
			day1 = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", day1);
			day2 = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", day2);
			datas = exportService.exportData(params,day1,day2);
		}else if (param == 2) {
			//按月份
			if (day2.length() ==1) {
				day2 = "0"+day2;
			}
			day1 = day1.substring(2) + day2;
			datas = exportService.exportByYear(params, day1);
		}else if (param == 3) {
			//按季度
			String year = StringUtil.getNowTime("yyyyMMddHHmm").substring(2, 4);
			int q = Integer.parseInt(day1);
			if (q==1) {
				day1 = year + "0101";
				day2 = year + "0331";
			}else if (q==2) {
				day1 = year + "0401";
				day2 = year + "0630";
			}else if (q==3) {
				day1 = year + "0701";
				day2 = year + "0930";
			}else if (q==4) {
				day1 = year + "1001";
				day2 = year + "1231";
			}
			 datas = exportService.exportData(params, day1, day2);
		}else if (param == 4) {
			//按具体日期
			String day = StringUtil.changeFormat("yyyy-MM-dd", "yyMMdd", day1);
			day1 = day;
			day2 = day;
			datas = exportService.exportData(params,day1, day2);
		}else if (param == 5) {
			//按年份
			day1 = day1.substring(2);
			datas = exportService.exportByYear(params, day1);
		}
		
		//下载文件名
		String fileName="BUOY" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		
		
		String[] moreParams = new String[params.length+2];
		moreParams[0] = "time";
		moreParams[1] = "b_buoyid";
		for (int i = 0; i < params.length; i++) {
			moreParams[i+2] = params[i];
		}
		
		List<String> r = Arrays.asList(moreParams);
		
		String[] paramsName = StringUtil.getParamsName(moreParams);
		List<String> name = Arrays.asList(paramsName);
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(null, "/upload/", fileName,name, r, flushRows);
		excelExportSXXSSF.writeDatasByObject(datas);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			excelExportSXXSSF.getWb().write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        
        return null;
		
	}
	
}
