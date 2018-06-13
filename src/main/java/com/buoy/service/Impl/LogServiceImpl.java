package com.buoy.service.Impl;

import java.util.List;

import javax.enterprise.inject.ResolutionException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buoy.entity.Alarmlog;
import com.buoy.mapper.AlarmlogMapper;
import com.buoy.mapper.BuoylogMapper;
import com.buoy.mapper.UserlogMapper;
import com.buoy.service.LogService;
import com.buoy.util.ExcelExportSXXSSF;
import com.buoy.util.Page;
@Service
public class LogServiceImpl implements LogService {
	protected static Logger logger = Logger.getLogger(LogServiceImpl.class);

	@Autowired
	private BuoylogMapper buoylogMapper;
	@Autowired
	private AlarmlogMapper alarmlogMapper;
	@Autowired
	private UserlogMapper userlogMapper;
//	@Override
//	public List<Buoylog> selectAll(Page page) {
//		
////		int count = buoylogMapper.selectCount();
//		List<Buoylog> buoylogs = buoylogMapper.selectAll(page);
//		return buoylogs;
//	}
	@Override
	public int selectCount(String fromDay,String toDay,Integer type) {
		int count = 0;
		switch(type) {
			case 1:{
				count = alarmlogMapper.selectCount(fromDay, toDay);
				break;
			}
			case 2: {
				count = buoylogMapper.selectCount(fromDay,toDay);
				break;
			}
			case 3: {
				count = userlogMapper.selectCount(fromDay, toDay);
				break;
			}
			default:count = 0;
			
		}
		return count;
	}
	@Override
	public List<?> selectAll(Page page,String fromDay,String toDay,Integer type) {
		//todo 校验
		List<?> list = null;
		switch(type) {
			case 1:{
				logger.info("获取报警日志...");
				list = alarmlogMapper.selectByPage(page, fromDay, toDay);
				break;
			}
			case 2: {
				logger.info("获取浮标管理日志...");
				list = buoylogMapper.selectByPage(page, fromDay, toDay);
				break;
			}
			case 3: {
				logger.info("获取用户管理日志...");
				list = userlogMapper.selectByPage(page, fromDay, toDay);
				break;
			}
			default: list = null;
				
		}
		
		return list;
	}
	@Override
	public ExcelExportSXXSSF exportDatas(String fileName,
		List<String> fieldNames,List<String> fieldCodes, Integer flushRows,Integer type,Integer all,
		String fromDay,String toDay,String[] sheetName) throws Exception {
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(fileName,fieldNames, fieldCodes, flushRows);
		
		if (all != null && all == 1) {
			List<?> datas1 = alarmlogMapper.selectByPage(null, fromDay, toDay);
			List<?> datas2 = buoylogMapper.selectByPage(null, fromDay, toDay);
			List<?> datas3 = userlogMapper.selectByPage(null, fromDay, toDay);
			excelExportSXXSSF.writeDatasByObject(datas1,sheetName[0]);
			excelExportSXXSSF.writeDatasByObject(datas2,sheetName[1]);
			excelExportSXXSSF.writeDatasByObject(datas3,sheetName[2]);
		} else if(type != null) {
			List<?> datas = null;
			if (type == 1) {
				datas = alarmlogMapper.selectByPage(null, fromDay, toDay);
			}else if(type == 2) {
				datas = buoylogMapper.selectByPage(null, fromDay, toDay);
			}else if (type == 3) {
				datas = userlogMapper.selectByPage(null, fromDay, toDay);
			}else {
				throw new ResolutionException("请选择正确的参数");
			}
			excelExportSXXSSF.writeDatasByObject(datas,sheetName[type-1]);
		}
		return excelExportSXXSSF;
	}
	@Override
	public List<Alarmlog> getAlarmLogByActive() {
		return alarmlogMapper.getActiveLog();
	}
	@Override
	public int updateAlarmLog(Integer id) {
		return alarmlogMapper.updateActiveLog(id);
	}
	
	/*@Override
	public List<?> selectBylike(String day, Integer type) {
		List<?> list = null;
		switch(type) {
			case 1:{
				logger.info("获取报警日志");
				list = alarmlogMapper.selectLike(day);
				break;
			}
			case 2: {
				logger.info("获取浮标管理日志");
				list = buoylogMapper.selectLike(day);
				break;
			}
			default: list = null;
				
		}
		return list;
	}*/
	

}
