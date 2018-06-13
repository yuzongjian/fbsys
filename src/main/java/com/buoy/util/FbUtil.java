package com.buoy.util;
/**
 * 浮标工具类
 * 2017年8月28日
 * @author hongwu
 */
public class FbUtil {
	/**
	 * 浮标距离计算
	 * @param x0 布放经度
	 * @param y0 布放纬度
	 * @param x1 目前经度
	 * @param y1 目前纬度
	 */
	public static Double stateCalculate(String x0,String y0,String x1,String y1) {
		Double dx0 = Double.parseDouble(x0) / 10000.0 ;
		Double dy0 = Double.parseDouble(y0) / 10000.0 ;
		Double dx1 = Double.parseDouble(x1) / 10000.0 ;
		Double dy1 = Double.parseDouble(y1) / 10000.0 ;
//		System.out.println(dx0);
//		System.out.println(dy0);
//		System.out.println(dx1);
//		System.out.println(dy1);
		Double result = Math.acos(
				Math.cos(Math.toRadians(dy0)) * 
				Math.cos(Math.toRadians(dy1)) *
				Math.cos(Math.toRadians(dx0) - Math.toRadians(dx1)) + 
				Math.sin(Math.toRadians(dy0)) * 
				Math.sin(Math.toRadians(dy1)) 
				) * 6371.012;
		
		return result;
	}
//	stateCompare(S)
	
}
