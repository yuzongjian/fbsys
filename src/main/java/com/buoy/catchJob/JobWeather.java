package com.buoy.catchJob;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.buoy.entity.Current;
import com.buoy.entity.ReceiveTime;
import com.buoy.entity.Weather;
import com.buoy.service.JobService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;

public class JobWeather implements Job{
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private ReceiveTimeServiceImpl rts;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Weather> weathers = new ArrayList<>();
		String newTime = null;
//		System.out.println("---jobBLOG");
//		ReceiveTime receiveTime = rts.getByBuoyId(1);
//		System.out.println(receiveTime);
		
		List<ReceiveTime> receiveTimes = rts.getListByStatus(0);
		
		
		try {
			connection = AccessDBUtil.getConnection();
			int totalCount = 0;
			String lastTime = null;
			st = connection.createStatement();
			for (ReceiveTime rt : receiveTimes) {
				int total = 0;
				if (rt != null && rt.getWeather() != null ) {
					String sqlCount = "select count(*) from TabQIXG where 日期时间  > \'"+rt.getWeather()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(天气)"+rt.getBuoyName()+"-"+totalCount);
					//最后更新buoy时间
					lastTime = rt.getWeather();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabQIXG where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String buoyId = rs.getString("浮标号");
							String date = rs.getString("日期时间");
							String airpre = rs.getString("气压");
							String airtemp = rs.getString("气温");
							String wattemp = rs.getString("水温");
							String hatchtemp = rs.getString("舱温");
							String oppohumi= rs.getString("相对湿度");
							
							
							Weather w = new Weather();
							w.setDate(date);
							w.setwBuoyid(buoyId);
							w.setwAirpre(airpre);
							w.setwAirtemp(airtemp);
							w.setwWattemp(wattemp);
							w.setwHatchtemp(hatchtemp);
							w.setwOppohumi(oppohumi);
							
							weathers.add(w);
							
						}
					
						if (weathers.size() > 0) {
							newTime = weathers.get(weathers.size() - 1).getDate();
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addWeatherList(weathers);
						//resultCount+=result_;
						 
						rts.updateWeatherById(newTime, rt.getId());
						
//						lastTimeImpl.updateWithDate(newTime, "buoy");
						
						total += result_;
						weathers.clear();
					}
					System.out.println("天气："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
		
	}

}
