package com.buoy.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buoy.entity.Alarm;
import com.buoy.entity.Alarmlog;
import com.buoy.entity.Buoy;
import com.buoy.entity.Buoylog;
import com.buoy.entity.Current;
import com.buoy.entity.Station;
import com.buoy.entity.StatisticsVo;
import com.buoy.entity.User;
import com.buoy.entity.Waterquality;
import com.buoy.entity.Wind;
import com.buoy.mapper.AlarmMapper;
import com.buoy.mapper.AlarmlogMapper;
import com.buoy.mapper.BuoyMapper;
import com.buoy.mapper.BuoylogMapper;
import com.buoy.mapper.ExportMapper;
import com.buoy.mapper.StationMapper;
import com.buoy.mapper.UserMapper;
import com.buoy.mapper.WaterqualityMapper;
import com.buoy.mapper.WindMapper;
import com.buoy.service.LastTimeService;
import com.buoy.service.StatisticsService;
import com.buoy.service.UserService;
import com.buoy.util.AccessDBUtil;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class test {
//	@Autowired
//	private BuoyService buoyServiceImp;
	@Autowired 
	private LastTimeService lastTimeServiceImpl;
	@Autowired
	private StatisticsService statisticsServiceImpl;
	@Autowired
	private LastTimeService lastTimeImpl;
//	@Autowired
//	private CurrentService currentServiceImpl;
	@Autowired
	private BuoyMapper buoyMapper;
	@Autowired
	private BuoylogMapper buoylogMapper;
	@Autowired
	private WindMapper windMapper;
	@Autowired
	private WaterqualityMapper waterqualityMapper;
	@Autowired
	private ExportMapper exportMapper;
	@Autowired
	private StationMapper stationMapper;
	@Autowired
	private AlarmMapper alarmMapper;
	@Autowired
	private AlarmlogMapper alarmLogMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userServiceImpl;
	@Test
	public void testadd(){
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		try {
			connection = AccessDBUtil.getConnection();
			
			st = connection.createStatement();
			rt = st.executeQuery("select top 6 * from TabOLYM ");
			
			while(rt.next()){
				String buoyDate = rt.getString("日期时间 ").trim();
				String buoyId = rt.getString("浮标号").trim();
//				String mnum = rt.getString("主控编号");
//				String rw = rt.getString("接收方式");
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
//				String ridlight_status = rt.getString("锚灯状态");
//				String waterpolice_status = rt.getString("水警状态");
//				String shift_status = rt.getString("移位状态");
				String free = rt.getString("剩余空间");
				String sensor = rt.getString("传感器");
//				String sensor_status = rt.getString("传感器状态");
				String sensor_police = rt.getString("传感器报警");
				String break_status = rt.getString("故障状态");
				String datasfrom = rt.getString("数据来源");
				
				DateFormat dt = new SimpleDateFormat("yyMMddhhmm");
				Date date = dt.parse(buoyDate);
				System.out.println(date);
				
				Buoy buoy = new Buoy();
				buoy.setDate(buoyDate);
				buoy.setbBuoyid(buoyId);
				buoy.setbLongitude(longitude);
				buoy.setbLatitude(latitude);
				buoy.setbBearing(bearing);
				buoy.setbVoltage(voltage);
				buoy.setbRidlight(ridlight);
				buoy.setbWatpolice(waterpolice);
				buoy.setbDoorpolice(doorpolice);
				buoy.setbShift(shift);
				buoy.setbHatch(hatch);
				buoy.setbPlice(police);
				buoy.setbFree(free);
				buoy.setbSensor(sensor);
				buoy.setbSensorPolice(sensor_police);
				buoy.setbBreakStatus(break_status);
				buoy.setbDatafrom(datasfrom);
				
				System.out.println(buoy);
				
//				buoyServiceImp.addBuoy(buoy);
//				System.out.println("添加"+i);
				System.out.println(buoyId);
			}
			
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		System.out.println("-----------------------");
		
	}
	@Test
	public void testLastTime(){
		String str = lastTimeServiceImpl.selectByBuoyName("wave");
		System.out.println(str);
	}
	@Test
	public void testLastTime2(){
		DateFormat dt = new SimpleDateFormat("yyMMddHHmm");
		String format = dt.format(new Date());
		System.out.println(format);
		
		int i = lastTimeServiceImpl.updateWithDate(format, "wave");
		System.out.println(i);
	}
	
	/*@Test
	public void testStatistics(){
		StatisticsVo last = statisticsServiceImpl.selectTheLast("QF306");
		System.out.println(last);
	}*/
	@Test
	public void test3() {
		List<Current> currents = new ArrayList<>();
		Connection connection = null;
		Statement st = null;
		ResultSet rt = null;
		String lastTime = lastTimeImpl.selectByBuoyName("current");
		try {
			connection = AccessDBUtil.getConnection();
			st = connection.createStatement();
			rt = st.executeQuery("select * from TabADCP where 日期时间  > "+lastTime+" ORDER BY 日期时间  desc ");
			
			while(rt.next()){
				String buoyId = rt.getString("浮标号");
				String date = rt.getString("日期时间");
				String to1 = rt.getString("流速1");
				String speed1 = rt.getString("流向1");
//				String speed_maxtime = rt.getString("最大风速时间");
//				String speed_ji = rt.getString("极大风速");
//				String speed_jito = rt.getString("极大风速的风向");
//				String speed_jitime = rt.getString("极大风速时间");
//				String speed_ten = rt.getString("十分钟平均风速");
//				String speed_tento = rt.getString("十分钟平均风向");
//				String to_instant = rt.getString("瞬时风向");
//				String speed_instant = rt.getString("瞬时风速");
//				
				
				System.out.println(date+" "+buoyId+" "+to1+" "+ speed1);
				DateFormat dt = new SimpleDateFormat("yyMMddhhmm");
				Date d = dt.parse(date);
//				System.out.println(d);
				
				
				Current c = new Current();
				c.setcBuoyid(buoyId);
				c.setDate(date);
				c.setcTo1(to1);
				c.setcSpeed1(speed1);
				
				currents.add(c);
			}
			String newTime = null;
			if (currents.size() > 0) {
				newTime = currents.get(0).getDate();
//				System.out.println(newTime);
			}
			if (currents.size() > 0) {
				//DateFormat dt = new SimpleDateFormat("yyMMddHHmm");
				//if (newTime != null) {
				//newTime = dt.format(newTime);
				//}
				System.out.println(newTime);
				//lastTimeImpl.updateWithDate(newTime, "current");
				//int i = currentServiceImpl.addCurrentList(currents);
				//System.out.println("--添加current--"+i);
			}
//		for (Current c:currents) {
//			System.out.println(c.getDate()+" "+c.getcBuoyid());
//		}
//			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			AccessDBUtil.closeConnection(connection, st, rt);
		}
		System.out.println("-----------------------");
	}
	@Test
	public void test4() {
//		String[] s = buoyMapper.selectDateByDay("QF305", "170316");
//		for (String str:s) {
//			System.out.println(str);
//		}
		String[] s = statisticsServiceImpl.selectTimeByDay("QF305", "170316");
		for (String str:s) {
			System.out.println(str);
		}
	}
	@Test
	public void test5() {
//		Buoy b = buoyMapper.selectDateByDay("QF305", "1703161539");
		List<Waterquality> list = waterqualityMapper.selectTheLast24WithTime("QF305", "1703161538");
		System.out.println(list.size());
		for (Waterquality w:list) {
			System.out.println(w);
		}
//		for (String str:s) {
//			System.out.println(str);
//		}
//		System.out.println(b);
	}
	@Test
	public void test6() {
		List<Wind> list = windMapper.selectBetweenDay("QF305", null, null);
		for (Wind w:list) {
			System.out.println(w);
		}
		System.out.println(list.size());
	}
	@Test
	public void test7() {
		List<String> lists = new ArrayList<>();
		lists.add("wind_speed_max");
		lists.add("wind_speed_maxto");
		List<Wind> list = windMapper.selectToExport(lists, "QF305");
		for (Wind w:list) {
			System.out.println(w);
		}
		System.out.println(list.size());
	}
	@Test
	public void test8() {
		List<String> p = new ArrayList<>();
	
		p.add("w_airpre");
		p.add("w_airtemp");
		p.add("w_oppohumi");
		List<StatisticsVo> list = exportMapper.selectToExport("1703162359","1703172359",p);
		for (StatisticsVo w:list) {
			System.out.println(w);
		}
		System.out.println(list.size());
	}
	@Test
	public void test9() {
		List<String> p = new ArrayList<>();
	
//		statisticsServiceImplselectTheByDate("QF305","2017-03-17 10:49");
//		System.out.println(selectAllStation.size());
	}
	@Test
	public void test10() {
		List<Alarmlog> p = new ArrayList<>();
//		int i = stationMapper.saveOrUpdate();
//		System.out.println(i);
//		Alarm alarm = alarmMapper.selectByType("speed");
//		System.out.println(alarm);
		
//		Alarmlog log = new Alarmlog();
//		log.setDate("2017-03-27 15:27");
//		log.setDetails("测试插入1");
//		log.setSummary("测试1");
//		p.add(log);
//		log = new Alarmlog();
//		log.setDate("2017-03-27 15:28");
//		log.setDetails("测试插入2");
//		log.setSummary("测试2");
//		p.add(log);
//		int insertBatch = alarmLogMapper.insertBatch(p);
//		System.out.println(insertBatch)
		
//		List<Buoylog> list = buoylogMapper.selectByPage(null, "2017-03-22", "2017-03-23");
//		for(Buoylog a:list) {
//			System.out.println(a);
//		}
		User user = new User();
		user.setUsername("admin");
		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		System.out.println(salt2);
		String salt = user.getUsername() + salt2;
		System.out.println(salt);
		user.setSalt(salt);
		//user.setLocked(Boolean.TRUE);
//	user.setLocked();
		String hyjfbdmjsxt = "hyjfbdmjsxt";
		SimpleHash encodedPassword = new SimpleHash("md5", hyjfbdmjsxt,user.getUsername()+salt2,2);
		
		System.out.println(encodedPassword.toHex());
		user.setPassword(encodedPassword.toHex());
//		admin73c68bea8c8d0c69511b42cf8df86aed
//		7f9c9ec5d60da0e763569a885f48dacd
		
		//123456
//		5cc3b42fe2a8d3a23a24210df5dfe91b
//		admin8f40d24d091b49cdcb6cda9b7cdcf18c
		
	}
	@Test
	public void test11() {
//		String x0 = "1126335";
//		String y0 = "211161";
//		
//		String x1 = "1126341";
//		String y1 = "211161";
//		
		String x0 = "1154641";
		String y0 = "198605";
		
		String x1 = "1154591";
		String y1 = "198741";
		
		DecimalFormat df = new DecimalFormat("#.0000");  
		Double dx0 = Double.parseDouble(x0) / 10000.0 ;
		Double dy0 = Double.parseDouble(y0) / 10000.0 ;
		Double dx1 = Double.parseDouble(x1) / 10000.0 ;
		Double dy1 = Double.parseDouble(y1) / 10000.0 ;
		System.out.println(dx0);
		System.out.println(dy0);
		System.out.println(dx1);
		System.out.println(dy1);
		
		
		Double y = Math.acos(
				Math.cos(Math.toRadians(dy0)) * 
				Math.cos(Math.toRadians(dy1)) *
				Math.cos(Math.toRadians(dx0) - Math.toRadians(dx1)) + 
				Math.sin(Math.toRadians(dy0)) * 
				Math.sin(Math.toRadians(dy1)) 
				) * 6371.012;
		System.out.println(y);
	}
}
