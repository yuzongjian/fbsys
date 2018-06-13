package com.buoy.catchJob;

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

import com.buoy.entity.Buoy;
import com.buoy.entity.ReceiveTime;
import com.buoy.entity.Wave;
import com.buoy.service.JobService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;

public class JobBLOG implements Job{
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
		List<Wave> waves = new ArrayList<>();
		String newTime = null;
//		System.out.println("---jobBLOG");
//		ReceiveTime receiveTime = rts.getByBuoyId(1);
//		System.out.println(receiveTime);
		
		List<ReceiveTime> receiveTimes = rts.getListByStatus(0);
		try {
			connection = AccessDBUtil.getConnection();
			String lastTime = null;
			st = connection.createStatement();
			int totalCount = 0;
			for (ReceiveTime rt : receiveTimes) {
				int total = 0;
				if (rt != null && rt.getWave() != null ) {
					String sqlCount = "select count(*) from TabBLOG where 日期时间  > \'"+rt.getWave()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(波)："+totalCount);
					//最后更新buoy时间
					lastTime = rt.getWave();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabBLOG where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String bouyId = rs.getString("浮标号");
							String date = rs.getString("日期时间");
							String high_max = rs.getString("最大波高");
							String high_tenth = rs.getString("十分之一波高");
							String high_average = rs.getString("平均波高");
							String high_effective = rs.getString("有效波高");
							String cycle_max = rs.getString("最大波周期");
							String cycle_tenth = rs.getString("十分之一波周期");
							String cycle_average = rs.getString("平均波周期");
							String cycle_effective = rs.getString("有效波周期");
							String to = rs.getString("波向");
							String count = rs.getString("波数");
							String dataid  = rs.getString("数据id");
							
							
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
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addWaveList(waves);
						total += result_;
						 
						rts.updateWaveById(newTime, rt.getId());
						
//						lastTimeImpl.updateWithDate(newTime, "buoy");
						
//						total += result_;
						waves.clear();
					}
					System.out.println("波："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
		
	}

}
