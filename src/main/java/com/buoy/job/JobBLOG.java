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

import com.buoy.entity.Wave;
import com.buoy.service.JobService;
import com.buoy.service.LastTimeService;
import com.buoy.util.AccessDBUtil;
/**
 * 波job
 * @author Howard
 * 2017年3月6日
 */
public class JobBLOG implements Job{
	
	protected static Logger logger = Logger.getLogger(JobBLOG.class);
	
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private LastTimeService lastTimeImpl;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Wave> waves = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		ResultSet rt2 = null;
		String lastTime = lastTimeImpl.selectByBuoyName("wave");
		logger.info("查找最新波数据!上次最新时间:"+lastTime);
		try {
			connection = AccessDBUtil.getConnection();
			
			st = connection.createStatement();
			rt2 = st.executeQuery("select count(*) from TabBLOG where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间  desc ");
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
					 sql = "select * from TabBLOG where 日期时间  > \'"+lastTime+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}else {
					 sql = "select * from TabBLOG where (日期时间  > \'"+lastTime+"\') OR ( 日期时间  = \'"+lastTime+"\'  AND 浮标号 > \'"+buoy+"\' ) ORDER BY 日期时间 , 浮标号  limit 0,1000";
				}
				rt = st.executeQuery(sql);
				while(rt.next()){
					String bouyId = rt.getString("浮标号");
					String date = rt.getString("日期时间");
					String high_max = rt.getString("最大波高");
					String high_tenth = rt.getString("十分之一波高");
					String high_average = rt.getString("平均波高");
					String high_effective = rt.getString("有效波高");
					String cycle_max = rt.getString("最大波周期");
					String cycle_tenth = rt.getString("十分之一波周期");
					String cycle_average = rt.getString("平均波周期");
					String cycle_effective = rt.getString("有效波周期");
					String to = rt.getString("波向");
					String count = rt.getString("波数");
					String dataid  = rt.getString("数据id");
					
					
					Wave wave = new Wave();
					wave.setDate(date);
					wave.setwBuoyid(bouyId);
					wave.setwHighMax(high_max);
					wave.setwHighTenth(high_tenth);
					wave.setwHighAverage(high_average);
					wave.setwHighEffective(high_effective);
					wave.setwCycleMax(cycle_max);
					wave.setwCycleTenth(cycle_tenth);
					wave.setwCycleAverage(cycle_average);
					wave.setwCycleEffective(cycle_effective);
					wave.setwTo(to);
					wave.setwCount(count);
					wave.setwDateid(dataid);
					
					waves.add(wave);
					
				}
				
				if (waves.size() > 0) {
					newTime = waves.get(waves.size() - 1).getDate();
					buoy = waves.get(waves.size() - 1).getwBuoyid();
				}
				lastTime = newTime;
				int result_ = jobServiceImpl.addWaveList(waves);
				resultCount+=result_;
				lastTimeImpl.updateWithDate(newTime, "wave");
				waves.clear();
			}
			
			logger.info("添加波数据"+resultCount+"条,最新时间："+newTime);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.info("接收波数据出现异常");
			e.printStackTrace();
		}finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		
	}

}
