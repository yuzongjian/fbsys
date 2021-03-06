package com.buoy.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.buoy.entity.Weather;
import com.buoy.service.JobService;
import com.buoy.service.LastTimeService;
import com.buoy.util.AccessDBUtil;

public class JobWeather implements Job{
	protected static Logger logger = Logger.getLogger(JobWeather.class);

	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private LastTimeService lastTimeImpl;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Weather> weathers = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		ResultSet rt2 = null;
		String lastTime = lastTimeImpl.selectByBuoyName("weather");
		logger.info("查找最新天气数据!上次最新时间:"+lastTime);
		try {
			connection = AccessDBUtil.getConnection();
			st = connection.createStatement();
			rt2 = st.executeQuery("select count(*) from TabQIXG where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间  desc ");
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
					 sql = "select * from TabQIXG where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}else {
					 sql = "select * from TabQIXG where (日期时间  > \'"+lastTime+"\') OR ( 日期时间  = \'"+lastTime+"\'  AND 浮标号 > \'"+buoy+"\' ) ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}
				rt = st.executeQuery(sql);
				while(rt.next()){
					String buoyId = rt.getString("浮标号");
					String date = rt.getString("日期时间");
					String airpre = rt.getString("气压");
					String airtemp = rt.getString("气温");
					String wattemp = rt.getString("水温");
					String hatchtemp = rt.getString("舱温");
					String oppohumi= rt.getString("相对湿度");
					
					
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
					buoy = weathers.get(weathers.size() - 1).getwBuoyid();
				}
				lastTime = newTime;
				int result_ = jobServiceImpl.addWeatherList(weathers);
				resultCount+=result_;
				lastTimeImpl.updateWithDate(newTime, "weather");
				weathers.clear();
			}
				logger.info("添加天气数据"+totalCount+"条,最新时间："+newTime);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.info("接收天气数据出现异常");
			e.printStackTrace();
		}finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		
	}

}
