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

import com.buoy.entity.Wind;
import com.buoy.service.JobService;
import com.buoy.service.LastTimeService;
import com.buoy.util.AccessDBUtil;
/**
 * 风
 * @author Howard
 * 2017年3月6日
 */
public class JobWind implements Job{
	protected static Logger logger = Logger.getLogger(JobWind.class);

	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private LastTimeService lastTimeImpl;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Wind> winds = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		ResultSet rt2 = null;
		String lastTime = lastTimeImpl.selectByBuoyName("wind");
		logger.info("查找最新海风数据!上次最新时间:"+lastTime);
		try {
			connection = AccessDBUtil.getConnection();
			st = connection.createStatement();
			rt2 = st.executeQuery("select count(*) from TabFENG1 where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间  desc ");
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
					 sql = "select * from TabFENG1 where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}else {
					 sql = "select * from TabFENG1 where (日期时间  > \'"+lastTime+"\') OR ( 日期时间  = \'"+lastTime+"\'  AND 浮标号 > \'"+buoy+"\' ) ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}
				rt = st.executeQuery(sql);
				while(rt.next()){
					String buoyId = rt.getString("浮标号");
					String date = rt.getString("日期时间");
					String speed_max = rt.getString("最大风速");
					String speed_maxto = rt.getString("最大风速的风向");
					String speed_maxtime = rt.getString("最大风速时间");
					String speed_ji = rt.getString("极大风速");
					String speed_jito = rt.getString("极大风速的风向");
					String speed_jitime = rt.getString("极大风速时间");
					String speed_ten = rt.getString("十分钟平均风速");
					String speed_tento = rt.getString("十分钟平均风向");
					String to_instant = rt.getString("瞬时风向");
					String speed_instant = rt.getString("瞬时风速");
					
					Wind w = new Wind();
					w.setDate(date);
					w.setWindBuoyid(buoyId);
					w.setWindSpeedMax(speed_max);
					w.setWindSpeedMaxto(speed_maxto);
					w.setWindSpeedMaxtime(speed_maxtime);
					w.setWindSpeedJi(speed_ji);
					w.setWindSpeedJito(speed_jito);
					w.setWindSpeedJitime(speed_jitime);
					w.setWindSpeedTen(speed_ten);
					w.setWindSpeedTento(speed_tento);
					w.setWindSpeedInstant(speed_instant);
					w.setWindToInstant(to_instant);
					
					winds.add(w);
				}
				if (winds.size() > 0) {
					newTime = winds.get(winds.size() - 1).getDate();
					buoy = winds.get(winds.size() - 1).getWindBuoyid();
				}
				lastTime = newTime;
				int result_ = jobServiceImpl.addWindList(winds);
				resultCount+=result_;
				lastTimeImpl.updateWithDate(newTime, "wind");
				winds.clear();
			}
				
			logger.info("添加海风数据"+totalCount+"条,最新时间："+newTime);
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.info("接收海风数据出现异常");
			e.printStackTrace();
		} finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		
	}

}
