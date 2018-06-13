package com.buoy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 工具类 部分方法已弃用
 * @author hongwu
 *
 */
public class StringUtil {
	private StringUtil(){};
	public static String changeFormat(String srcDate) {
		DateFormat df = new SimpleDateFormat("yyMMddHHmm");
		DateFormat disdf = new SimpleDateFormat("HH:mm");
		Date parse = null;
		try {
			parse = df.parse(srcDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String time = disdf.format(parse);
		return time;
	}
	/**
	 * 根据格式返回当前日期
	 * @param format
	 * @return
	 */
	public static String getNowTime(String format) {
		DateFormat  dateFormat= new SimpleDateFormat(format);
		String date = dateFormat.format(new Date());
		return date;
	}
	
	public static String changeFormat(String source,String target,String srcDate) {
		DateFormat df = new SimpleDateFormat(source);
		DateFormat disdf = new SimpleDateFormat(target);
		Date parse = null;
		try {
			parse = df.parse(srcDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String time = disdf.format(parse);
		return time;
	}
	public static String changeToGetXXX(String field) {
		String[] split = field.split("_");
		StringBuilder str = new StringBuilder("get");
//		if (split.length == 0) {
//			str.append(field.substring(0, 1).toUpperCase()).append(field.substring(1));
//		} else {
//			
//		}
		for (String temp:split) {
			if (temp.length() > 1)
				str.append(temp.substring(0, 1).toUpperCase()).append(temp.substring(1));
			else str.append(temp);
		}
		return str.toString();
	}
	public static String changeToXXX(String field) {
		String[] split = field.split("_");
		StringBuilder str = new StringBuilder(split[0]);
		for (int i = 1; i < split.length; i++) {
			str.append(split[i].substring(0, 1).toUpperCase()).append(split[i].substring(1));
		}
		return str.toString();
	}
	/**
	 * 判断字符串是不是整数或者小数
	 * 如果不是，返回false 否则返回true
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0.0-9.0]*");  //123.2.2会被判定为true
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}
	/**
	 * change the format to Latitude and longitude
	 * 转为经纬度格式
	 * @param src
	 * @return
	 */
	public static String changeToLAL(String src) {
		if (src == null || "".equals(src)) {
			return null;
		}
		int t = 0;
		StringBuilder str = new StringBuilder(src.substring(src.length()-1, src.length()));
		for(int i = src.length()-2; i >= 0; i--) {
			if (t != 2 && t!= 4) {
				str.append(src.substring(i,i+1));
			}else if (t==2) {
				str.append("''").append(src.substring(i,i+1));
			}else {
				str.append("'").append(src.substring(i,i+1));
			}
			t++;
		}
		
		return reverse(str.toString());
	}
	/**
	 * 反转字符串
	 * @param origl
	 * @return
	 */
	public static String reverse(String origl){
		if(origl == null || origl.length()<=1){
			return origl;
		}
		return reverse(origl.substring(1))+origl.charAt(0);
	}
	public static String[] getParamsName(String[] params) {
//       String[] template = {"气压","气温","湿度","水温","盐度","电导率","流速","流向",
//				"最大波高","1/10波高","有效波高","平均波高","最大波周期","1/10波周期","有效波周期","平均波周期","波向",
//				"最大风速","极大风速","瞬时风速","平均风速","最大风向","极大风向","瞬时风向","平均风向"};
//		List<String> list = Arrays.asList(template);
		String[] paramsName = new String[params.length];
		Map<String, String> map = new HashMap<>();
		map.put("time","日期");
		map.put("b_buoyid", "浮标号");
		map.put("b_longitude","经度");
		map.put("b_latitude","纬度");
		map.put("b_watpolice","舱进水");
		map.put("b_doorpolice","舱门");
		map.put("b_shift","移位");
		map.put("b_hatch","舱盖");
		map.put("b_bearing","方位");
		map.put("b_voltage","电压");
		map.put("b_ridlight","锚灯");
		map.put("b_free","剩余空间");
		map.put("w_airpre", "气压");
		map.put("w_airtemp", "气温");
		map.put("w_oppohumi", "湿度");
		map.put("wq_wattemp", "水温");
		map.put("wq_salinity", "盐度");
		map.put("wq_conductivity", "电导率");
		map.put("c_speed1", "流速");
		map.put("c_to1", "流向");
		map.put("w_high_max", "最大波高");
		map.put("w_high_tenth", "1/10波高");
		map.put("w_high_effective", "有效波高");
		map.put("w_high_average", "平均波高");
		map.put("w_cycle_max", "最大波周期");
		map.put("w_cycle_tenth", "1/10波周期");
		map.put("w_cycle_effective", "有效波周期");
		map.put("w_cycle_average", "平均波周期");
		map.put("w_to", "波向");
		map.put("wind_speed_max", "最大风速");
		map.put("wind_speed_ji", "极大风速");
		map.put("wind_speed_instant", "瞬时风速");
		map.put("wind_speed_ten", "平均风速");
		map.put("wind_speed_maxto", "最大风向");
		map.put("wind_speed_jito", "极大风向");
		map.put("wind_to_instant", "瞬时风向");
		map.put("wind_speed_tento", "平均风向");
		
		for (int i = 0; i < params.length; i++) {
			paramsName[i] = map.get(params[i]);
		}
		
		
		return paramsName;
	}
	
	public static boolean checkScope(String str,String from,String to) {
		if (str == null || !checkNum(str) || "".equals(str)) {
			return false;
		}
		//boolean b = checkIntegerNum(str);
		double num = Double.parseDouble(str);
		if (from != null && to != null && !"".equals(from) && !"".equals(to) && checkNum(from) && checkNum(to)) {
			//记录日志 出现问题
			 double fromnum = Double.parseDouble(from);
			 double tonum = Double.parseDouble(to);
			 if (num >= fromnum && num <= tonum) {
				 return true;
			 }
		}
		return false;
//		if (from != null && to != null)
	}
	/**
	 * 判断是字符串是否由数字或小数点组成 不能判断空""字符串
	 * @param str
	 */
	public static boolean checkNum(String str) {
//		Boolean strResult = str.matches("-?[0-9]+.*[0-9]*");
		boolean strResult = str.matches("^[0-9]+(.[0-9]+)?$");
		return strResult;
	}
	/**
	 * 判断字符串是否为整数
	 * @param str
	 * @return
	 */
	public static boolean checkIntegerNum(String str) {
//		Boolean strResult = str.matches("-?[0-9]+.*[0-9]*");
		boolean strResult = str.matches("^[-\\+]?[\\d]*$");
		return strResult;
	}
	
	public static String changeToLongitude(String longitude){
		String formatLongitude = longitude.substring(0, 3) +"." + longitude.substring(3,longitude.length()-1);
		return formatLongitude;
	}
	public static String changeTLatitude(String latitude){
		String formatLatitude = latitude.substring(0, 2) +"." + latitude.substring(2,latitude.length()-1);
		return formatLatitude;
	}
	public static void main(String[] args) {
//		boolean numeric = isNumeric("123.2.2");
//		System.out.println(numeric);
		
//		String result = changeToLAL("213000N");
//		System.out.println(result);
//		String s = changeToXXX("w_airpre");
//		System.out.println(s);
//		
//		System.out.println(changeFormat("yyyy-MM-dd", "yyyy-MM-dd HH:mm", "2017-03-07"));;
//		System.out.println(checkIntegerNum(""));
//		double parseDouble = Double.parseDouble("");
//		System.out.println(parseDouble);
		
//		System.out.println(checkScope("", "20", "30"));
//		System.out.println(changeToLongitude("1135995E"));
//		System.out.println(changeTLatitude("213000N"));
		String s = StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", "2017-03-19 20:57");
		System.out.println(s);
		
		
	}
}
