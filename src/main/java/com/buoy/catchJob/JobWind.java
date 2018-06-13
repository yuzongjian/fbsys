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
import com.buoy.entity.Wind;
import com.buoy.service.JobService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;

public class JobWind implements Job{
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private ReceiveTimeServiceImpl rts;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Wind> winds = new ArrayList<>();
		String newTime = null;
		List<ReceiveTime> receiveTimes = rts.getListByStatus(0);
		
		try {
			connection = AccessDBUtil.getConnection();
			int totalCount = 0;
			String lastTime = null;
			st = connection.createStatement();
			for (ReceiveTime rt : receiveTimes) {
				int total = 0;
				if (rt != null && rt.getWind() != null ) {
					String sqlCount = "select count(*) from TabFENG1 where 日期时间  > \'"+rt.getWind()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(风)："+rt.getBuoyName()+"-"+totalCount);
					//最后更新buoy时间
					lastTime = rt.getWind();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabFENG1 where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String buoyId = rs.getString("浮标号");
							String date = rs.getString("日期时间");
							String speed_max = rs.getString("最大风速");
							String speed_maxto = rs.getString("最大风速的风向");
							String speed_maxtime = rs.getString("最大风速时间");
							String speed_ji = rs.getString("极大风速");
							String speed_jito = rs.getString("极大风速的风向");
							String speed_jitime = rs.getString("极大风速时间");
							String speed_ten = rs.getString("十分钟平均风速");
							String speed_tento = rs.getString("十分钟平均风向");
							String to_instant = rs.getString("瞬时风向");
							String speed_instant = rs.getString("瞬时风速");
							
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
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addWindList(winds);
						 
						rts.updateWindById(newTime, rt.getId());
						
						total += result_;
						winds.clear();
					}
					System.out.println("风 ："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
		
	}

}
