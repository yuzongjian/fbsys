package com.buoy.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AccessDBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		Properties properties = new Properties();
		try {
			properties.load(AccessDBUtil.class.getClassLoader().getResourceAsStream("accessdb.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		String year = StringUtil.getNowTime("yyyy");
		String newurl = url +  year+".mdb";
		return DriverManager.getConnection(newurl, user, password);
//		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection conn,Statement stm,ResultSet rs){
		try {
			if (conn != null)
				conn.close();
			if (stm != null)
				stm.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Map<Integer, Object[]> map = new HashMap<>();
		String[] column;
		ResultSet rs = null;
		Statement st = null;
		st = con.createStatement();
        
        rs = st.executeQuery("select * from TabBLOG where 日期时间  >= 1701010000");
        ResultSetMetaData metaDate = rs.getMetaData();     
        int number = metaDate.getColumnCount();     
        column = new String[number];     
        for (int j = 0;j < column.length; j++){     
            column[j] = metaDate.getColumnName(j + 1);     
            System.out.print(column[j]+"\t");  
        }     
        System.out.println();  
        int a = 0;  
      //输出数据  
        while(rs.next()){  
            a++;  
            Object[] rss = new Object[number];  
            for(int i = 0;i < rss.length; i++){  
                rss[i] = rs.getString(i + 1);    
                System.out.print(rss[i]+"\t");  
            }  
            System.out.println();  
            map.put(a, rss) ;                 
        }  
        closeConnection(con, st, rs);
	}
}
