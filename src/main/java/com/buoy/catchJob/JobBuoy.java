package com.buoy.catchJob;

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
import com.buoy.entity.ReceiveTime;
import com.buoy.entity.Wave;
import com.buoy.service.JobService;
import com.buoy.service.LastTimeService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;
/**
 * 波job
 * @author Howard
 * 2017年3月6日
 */
public class JobBuoy implements Job{
	
	protected static Logger logger = Logger.getLogger(JobBuoy.class);
	
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private ReceiveTimeServiceImpl rts;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Buoy> buoys = new ArrayList<>();
		String newTime = null;
		
		List<ReceiveTime> receiveTimes = rts.getListByStatus(0);
		
		
		try {
			connection = AccessDBUtil.getConnection();
			int totalCount = 0;
			String lastTime = null;
			st = connection.createStatement();
			for (ReceiveTime rt : receiveTimes) {
				int total = 0;
				if (rt != null && rt.getBuoy() != null ) {
					String sqlCount = "select count(*) from TabBLOG where 日期时间  > \'"+rt.getBuoy()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(浮标)"+rt.getBuoyName()+"-"+totalCount);
					//最后更新buoy时间
					lastTime = rt.getBuoy();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabOLYM where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String buoyDate = rs.getString("日期时间 ").trim();
							String buoyId = rs.getString("浮标号").trim();
							String longitude = rs.getString("经度").trim();
							String latitude = rs.getString("纬度").trim();
							String bearing = rs.getString("方位").trim();
							String voltage = rs.getString("电压").trim();
							String ridlight = rs.getString("锚灯").trim();
							String waterpolice = rs.getString("水警").trim();
							String doorpolice = rs.getString("门警").trim();
							String shift = rs.getString("移位");
							String hatch = rs.getString("舱盖");
							String police = rs.getString("报警");
							String free = rs.getString("剩余空间");
							String sensor = rs.getString("传感器");
							
//							DateFormat dt = new SimpleDateFormat("yyMMddhhmm");
//							Date date = dt.parse(buoyDate);
							
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
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addBuoyList(buoys);
						//resultCount+=result_;
						 
						rts.updateBuoyById(newTime, rt.getId());
						
//						lastTimeImpl.updateWithDate(newTime, "buoy");
						
						total += result_;
						buoys.clear();
					}
					System.out.println("浮标："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
	}

}
