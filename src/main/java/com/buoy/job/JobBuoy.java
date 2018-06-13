package com.buoy.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.buoy.entity.Buoy;
import com.buoy.service.JobService;
import com.buoy.service.LastTimeService;
import com.buoy.util.AccessDBUtil;
/**
 * 浮标job
 * @author Howard
 * 2017年3月6日
 */
public class JobBuoy implements Job{
	protected static Logger logger = Logger.getLogger(JobBuoy.class);

	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private LastTimeService lastTimeImpl;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Buoy> buoys = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		ResultSet rt2 = null;
		String lastTime = lastTimeImpl.selectByBuoyName("buoy");
		logger.info("查找最新浮标数据!上次最新时间:"+lastTime);
		
		
		
		try {
			
			connection = AccessDBUtil.getConnection();
			st = connection.createStatement();
			rt2 = st.executeQuery("select count(*) from TabOLYM where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间  desc ");
			int totalCount = 0;
			while(rt2.next()) {
				totalCount = rt2.getInt(1);
			}
			String buoy = null;
			String newTime = null;
			int resultCount = 0;
			String sql = null;
			int page = (totalCount + 1000 - 1) /1000;
			
			for (int i = 0 ; i < page; i ++ ) {
				if (i == 0) {
					 sql = "select * from TabOLYM where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}else {
					 sql = "select * from TabOLYM where (日期时间  > \'"+lastTime+"\') OR ( 日期时间  = \'"+lastTime+"\'  AND 浮标号 > \'"+buoy+"\' ) ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}
				rt = st.executeQuery(sql);
				
				while(rt.next()){
					String buoyDate = rt.getString("日期时间 ").trim();
					String buoyId = rt.getString("浮标号").trim();
					String longitude = rt.getString("经度").trim();
					String latitude = rt.getString("纬度").trim();
					String bearing = rt.getString("方位").trim();
					String voltage = rt.getString("电压").trim();
					String ridlight = rt.getString("锚灯").trim();
					String waterpolice = rt.getString("水警").trim();
					String doorpolice = rt.getString("门警").trim();
					String shift = rt.getString("移位");
					String hatch = rt.getString("舱盖");
					String police = rt.getString("报警");
					String free = rt.getString("剩余空间");
					String sensor = rt.getString("传感器");
					
					DateFormat dt = new SimpleDateFormat("yyMMddhhmm");
					Date date = dt.parse(buoyDate);
					
					Buoy buoy_ = new Buoy();
					buoy_.setDate(buoyDate);
					buoy_.setbBuoyid(buoyId);
					buoy_.setbLongitude(longitude);
					buoy_.setbLatitude(latitude);
					buoy_.setbBearing(bearing);
					buoy_.setbVoltage(voltage);
					buoy_.setbRidlight(ridlight);
					buoy_.setbWatpolice(waterpolice);
					buoy_.setbDoorpolice(doorpolice);
					buoy_.setbShift(shift);
					buoy_.setbHatch(hatch);
					buoy_.setbPlice(police);
					buoy_.setbFree(free);
					buoy_.setbSensor(sensor);
					
					buoys.add(buoy_);
					
				}
				
				if (buoys.size() > 0) {
					newTime = buoys.get(buoys.size() - 1).getDate();
					buoy = buoys.get(buoys.size() - 1).getbBuoyid();
				}
				lastTime = newTime;
				int result_ = jobServiceImpl.addBuoyList(buoys);
				resultCount+=result_;
				lastTimeImpl.updateWithDate(newTime, "buoy");
				buoys.clear();
			}
			
				logger.info("添加浮标数据"+resultCount+"条,最新时间："+newTime);
			
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			logger.info("接收浮标数据出现异常");
			e.printStackTrace();
		}finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		
	}

}
