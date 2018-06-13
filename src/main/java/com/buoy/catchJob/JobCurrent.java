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
import com.buoy.service.JobService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;

public class JobCurrent implements Job{
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private ReceiveTimeServiceImpl rts;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Current> currents = new ArrayList<>();
		String newTime = null;
		
		List<ReceiveTime> receiveTimes = rts.getListByStatus(0);
		
		
		try {
			connection = AccessDBUtil.getConnection();
			int totalCount = 0;
			String lastTime = null;
			st = connection.createStatement();
			for (ReceiveTime rt : receiveTimes) {
				int total = 0;
				if (rt != null && rt.getCurrent() != null ) {
					String sqlCount = "select count(*) from TabADCP where 日期时间  > \'"+rt.getCurrent()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(海流)："+rt.getBuoyName()+"-"+totalCount);
					//最后更新buoy时间
					lastTime = rt.getCurrent();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabADCP where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String buoyId = rs.getString("浮标号");
							String date = rs.getString("日期时间");
							String speed1 = rs.getString("流速1");
							String to1 = rs.getString("流向1");
							Current c = new Current();
							c.setcBuoyid(buoyId);
							c.setDate(date);
							c.setcTo1(to1);
							c.setcSpeed1(speed1);
							
							currents.add(c);
							
						}
					
						if (currents.size() > 0) {
							newTime = currents.get(currents.size() - 1).getDate();
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addCurrentList(currents);
						 
						rts.updateCurrentById(newTime, rt.getId());
						
//						lastTimeImpl.updateWithDate(newTime, "buoy");
						
						total += result_;
						currents.clear();
					}
					System.out.println("海流："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
		
	}

}
