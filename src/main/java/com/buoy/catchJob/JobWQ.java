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
import com.buoy.entity.Waterquality;
import com.buoy.service.JobService;
import com.buoy.service.Impl.ReceiveTimeServiceImpl;
import com.buoy.util.AccessDBUtil;

public class JobWQ implements Job{
	@Autowired
	private JobService jobServiceImpl;
	@Autowired
	private ReceiveTimeServiceImpl rts;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		List<Waterquality> waterqualities = new ArrayList<>();
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
				if (rt != null && rt.getWaterQuality() != null ) {
					String sqlCount = "select count(*) from TabSHZH where 日期时间  > \'"+rt.getWaterQuality()+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间  desc";
					rs = st.executeQuery(sqlCount);
					while(rs.next()) {
						totalCount = rs.getInt(1);
					}
					System.out.println("总(水质)"+rt.getBuoyName()+"-"+totalCount);
					//最后更新buoy时间
					lastTime = rt.getWaterQuality();
					String sql = null;
					int page = (totalCount + 1000 - 1) /1000;
					
					for (int i = 0 ; i < page; i ++ ) {
						sql = "select * from TabSHZH where 日期时间  > \'"+lastTime+"\' and 浮标号 = \'"+rt.getBuoyName()+"\' ORDER BY 日期时间 , 浮标号  limit 0,1000";
						rs = st.executeQuery(sql);
						
						while(rs.next()){
							String date = rs.getString("日期时间 ");
							String buoyId = rs.getString("浮标号");
							String wattmp = rs.getString("水温");
							String salinity = rs.getString("盐度");
							String conductivity = rs.getString("电导率");
							Waterquality w = new Waterquality();
							w.setDate(date);
							w.setWqBuoyid(buoyId);
							w.setWqWattemp(wattmp);
							w.setWqSalinity(salinity);
							w.setWqConductivity(conductivity);
							
							waterqualities.add(w);
							
						}
					
						if (waterqualities.size() > 0) {
							newTime = waterqualities.get(waterqualities.size() - 1).getDate();
						}
						lastTime = newTime;
						int result_ = jobServiceImpl.addWaterQualityList(waterqualities);
						rts.updateWaterqualityById(newTime, rt.getId());
						
						total += result_;
						waterqualities.clear();
					}
					System.out.println("水质："+rt.getBuoyName()+"-"+total);
				}
			}	
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			AccessDBUtil.closeConnection(connection, st, rs);
		}
		
		
	}

}
