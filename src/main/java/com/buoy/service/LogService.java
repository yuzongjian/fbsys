package com.buoy.service;

import java.util.List;

import com.buoy.entity.Alarmlog;
import com.buoy.entity.Buoylog;
import com.buoy.util.ExcelExportSXXSSF;
import com.buoy.util.Page;

public interface LogService {
//	public List<Buoylog> selectAll(Page page);
	public int selectCount(String fromDay,String toDay,Integer type);
	public List<?> selectAll(Page page,String fromDay,String toDay,Integer type);
//	public List<?> selectBylike(String day,Integer type);
	ExcelExportSXXSSF exportDatas(String fileName, List<String> fieldNames, List<String> fieldCodes, Integer flushRows,
			Integer type, Integer all, String fromDay, String toDay, String[] sheetName) throws Exception;
	
	public List<Alarmlog> getAlarmLogByActive();
	public int updateAlarmLog(Integer id);
}
