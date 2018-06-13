package com.buoy.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.buoy.exception.ExceptionResultInfo;
import com.buoy.service.LogService;
import com.buoy.util.Constant;
import com.buoy.util.ExcelExportSXXSSF;
import com.buoy.util.Page;
import com.buoy.util.ResultInfo;
import com.buoy.util.StringUtil;
/**
 * 日志管理
 * @author hongwu
 *
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController{
	
	@Autowired
	private LogService logService;
	@RequiresAuthentication
	@RequestMapping("")
	public String viewLog() {
		return "/log";
	}
	@RequiresAuthentication
	@RequiresPermissions("log")
	@RequestMapping(value="/getall")
	public @ResponseBody void getAllLogs(Integer pageno,String fromDay,String toDay,Integer type) throws JsonGenerationException, JsonMappingException, IOException, ExceptionResultInfo {
		if (fromDay != null && toDay !=null) {
			logger.info("获取"+fromDay+"到"+toDay+"的数据!");
			if (fromDay.compareTo(toDay) > 0) {
				throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"起始日期不能大于结束日期!!!");
			}
		}
		if (type == null || type > 4 ||type < 1) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"请选择正确的类型");
		}
		if (pageno == null || pageno <= 0) {
			pageno = 1;
		}
		int total = logService.selectCount(fromDay,toDay,type);
		Page page = new Page(10, pageno);
		page.setTotal(total);
		List<?> buoylogs = logService.selectAll(page, fromDay, toDay,type);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("logs", buoylogs);
		map.put("page", page);
		ResultInfo result = new ResultInfo(Constant.TYPE_RESULT_SUCCESS,0,"获取浮标日志成功!");
		result.setSysdata(map);
		response.setCharacterEncoding("UTF-8"); //设置编码格式
		response.setContentType("text/html");   //设置数据格式
		String data = JSON.toJSONString(result);
		PrintWriter out = response.getWriter(); //获取写入对象
		out.print(data); //将json数据写入流中
		
		out.flush();
	}
	/**
	 * 导出日志
	 * @param data
	 * @param day1
	 * @param day2
	 * @param type
	 * @param all
	 * @param param
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequiresAuthentication
	@RequiresPermissions("export")
	@RequestMapping("/export")
	public String ExportData(String data,
							String day1,
							String day2,
							Integer type,
							Integer all,
							Integer param,
							HttpServletResponse response) throws Exception {
		
		String[] sheetName = new String[]{"报警日志","浮标日志","用户日志"};
		String fileName="LOG" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		List<String> fieldNames  = new ArrayList<>();
		fieldNames.add("事件时间");
		fieldNames.add("事件标题");
		fieldNames.add("事件说明");
		List<String> fieldCodes   = new ArrayList<>();
		fieldCodes.add("date");
		fieldCodes.add("summary");
		fieldCodes.add("details");
		
		if (param == 2) {
			day2 = day1;
		}else if (param == 3) {
			String year = StringUtil.getNowTime("yyyyMMddHHmm").substring(0, 4);
			int q = Integer.parseInt(day1);
			if (q==1) {
				day1 = year + "-01-01";
				day2 = year + "-03-31";
			}else if (q==2) {
				day1 = year + "-04-01";
				day2 = year + "-06-30";
			}else if (q==3) {
				day1 = year + "-07-01";
				day2 = year + "-09-30";
			}else if (q==4) {
				day1 = year + "-10-01";
				day2 = year + "-12-31";
			}
		}else if (param == 4) {
			if (day2.length() ==1) {
				day2 = "-0"+day2;
			}
			day1 = day1 + day2;
			day2 = null;
		}else if (param == 5) {
			day2 = null;
		}
		if (param == null || param < 1 || param > 5) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "参数错误");
		}
		ExcelExportSXXSSF excelExportSXXSSF = logService.exportDatas(fileName, fieldNames, fieldCodes, flushRows, type, all, day1, day2, sheetName);
		
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
	/*@RequestMapping("/export")
	public String ExportData(String data,
							String day1,
							String day2,
							Integer type,
							Integer all,
							Integer param,
							HttpServletResponse response) throws Exception {
		System.out.println(day1+"-"+day2+"-"+type+"-"+all);
		
		String fileName="LOG" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		List<String> fieldNames  = new ArrayList<>();
		fieldNames.add("事件时间");
		fieldNames.add("事件标题");
		fieldNames.add("事件说明");
		List<String> fieldCodes   = new ArrayList<>();
		fieldCodes.add("date");
		fieldCodes.add("summary");
		fieldCodes.add("details");
		
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(fileName,fieldNames, fieldCodes, flushRows);
		if (param == null || (param != 1 && param != 2 && param != 3)) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "参数错误");
		}
		//按日查询
		if (param == 2) {
			day2 = day1;
		}else if (param == 3) {
			String year = StringUtil.getNowTime("yyyyMMddHHmm").substring(0, 4);
			int q = Integer.parseInt(day1);
			if (q==1) {
				day1 = year + "-01-01";
				day2 = year + "-03-31";
			}else if (q==2) {
				day1 = year + "-04-01";
				day2 = year + "-06-30";
			}else if (q==3) {
				day1 = year + "-07-01";
				day2 = year + "-09-30";
			}else if (q==4) {
				day1 = year + "-10-01";
				day2 = year + "-12-31";
			}
		}
		if (all != null && all == 1) {
			List<?> datas1 = logService.selectAll(null, day1, day2, 1);
			List<?> datas2 = logService.selectAll(null, day1, day2, 2);
			excelExportSXXSSF.writeDatasByObject(datas1,"报警日志");
			excelExportSXXSSF.writeDatasByObject(datas2,"浮标日志");
		} else if(type != null) {
			if (type == 1) {
				List<?> datas1 = logService.selectAll(null, day1, day2, type);
				excelExportSXXSSF.writeDatasByObject(datas1,"报警日志");
			}else if(type == 2) {
				List<?> datas2 = logService.selectAll(null, day1, day2, 2);
				excelExportSXXSSF.writeDatasByObject(datas2,"浮标日志");
			}else if (type == 3) {
				//todo
			}
		}else {
			throw new ResolutionException("请选择正确的参数");
		}
		//System.out.println(list);
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
	
	/*@RequestMapping("/exportWithYearOrMonth")
	public String ExportDataWithYearOrMonth(String data,
							String day1,
							String day2,
							Integer type,
							Integer all,
							Integer param,
							HttpServletResponse response) throws Exception {
		
		String fileName="LOG" + StringUtil.getNowTime("yyyyMMddHHmm");
		int flushRows=100;
		List<String> fieldNames  = new ArrayList<>();
		fieldNames.add("事件时间");
		fieldNames.add("事件标题");
		fieldNames.add("事件说明");
		List<String> fieldCodes   = new ArrayList<>();
		fieldCodes.add("date");
		fieldCodes.add("summary");
		fieldCodes.add("details");
		
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(fileName,fieldNames, fieldCodes, flushRows);
		//按日查询
		if (param == null || (param != 5 && param != 4)) {
			throw new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL, "参数错误");
		}
		//按月份
		if (param == 4) {
			if (day2.length() ==1) {
				day2 = "-0"+day2;
			}
			day1 = day1 + day2;
		}
		
		
		
		if (all != null && all == 1) {
			List<?> datas1 = logService.selectBylike(day1, 1);
			List<?> datas2 = logService.selectBylike(day1, 2);
			excelExportSXXSSF.writeDatasByObject(datas1,"报警日志");
			excelExportSXXSSF.writeDatasByObject(datas2,"浮标日志");
		} else if(type != null) {
			List<?> datas1 = logService.selectBylike(day1, type);
			if (type == 1) {
				excelExportSXXSSF.writeDatasByObject(datas1,"报警日志");
			}else if(type == 2) {
				excelExportSXXSSF.writeDatasByObject(datas1,"浮标日志");
			}else if (type == 3) {
				//todo
			}
		}else {
			throw new ResolutionException("请选择正确的参数");
		}
		//System.out.println(list);
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
	*/
	
	
	
}
