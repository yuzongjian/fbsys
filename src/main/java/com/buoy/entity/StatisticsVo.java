package com.buoy.entity;


public class StatisticsVo {
	/**
	 * 站位号
	 */
	private String station;
	/**
	 * 浮标号
	 */
	private String bBuoyid;
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 经度
	 */
	private String bLongitude;
	/**
	 * 纬度
	 */
    private String bLatitude; 
    /**
     * 原始经纬度
     */
    private String oLongitude;
    private String oLatitude; 
    /**
     * 偏移距离
     */
    private String moveDistance;
    /**
     * 水警
     */
    private String bWatpolice;
    /**
     * 门警
     */
    private String bDoorpolice;
    /*
     * 移位
     */
    private String bShift;
    /**
     * 舱盖
     */
    private String bHatch;
    /**
     * 方位
     */
    private String bBearing;
    /**
     * 电压
     */
    private String bVoltage;
    /**
     * 锚灯
     */
    private String bRidlight;
    /**
     * 剩余空间
     */
    private String bFree;
    /**
     * 气压
     */
    private String wAirpre;
    /**
     * 气温
     */
    private String wAirtemp;
    /**
     * 湿度
     */
    private String wOppohumi;
    /**
     * 水温
     */
    private String wqWattemp;
    /**
     * 盐度
     */
    private String wqSalinity;
    /**
     * 电导度
     */
    private String wqConductivity;
    /**
     * 流速
     */
    private String cSpeed1;
    /**
     * 流向
     */
    private String cTo1;
    /**
     * 最大波高
     */
    private String wHighMax;
    /**
     * 十分之一波高
     */
    private String wHighTenth;
    /**
     * 平均波高
     */
    private String wHighAverage;
    /**
     * 有效波高
     */
    private String wHighEffective;
    /**
     * 最大波周期
     */
    private String wCycleMax;
    /**
     * 十分之一波周期
     */
    private String wCycleTenth;
    /**
     * 平均波周期
     */
    private String wCycleAverage;
    /**
     * 有效波周期
     */
    private String wCycleEffective;
    /**
     * 波向
     */
    private String wTo;
    /**
     * 最大风速
     */
    private String windSpeedMax;
    /**
     * 最大风速风向
     */
    private String windSpeedMaxto;
    /**
     * 极大风速
     */
    private String windSpeedJi;
    /**
     * 极大风速风向
     */
    private String windSpeedJito;
    /**
     * 十分钟风速
     */
    private String windSpeedTen;
    /**
     * 十分钟风速的风向
     */
    private String windSpeedTento;
    /**
     * 瞬时风速
     */
    private String windSpeedInstant;
    /**
     * 瞬时风向
     */
    private String windToInstant;
    /**
     * 标记是否故障
     */
    private int isFault;
    
	public int getIsFault() {
		return isFault;
	}
	public void setIsFault(int isFault) {
		this.isFault = isFault;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
//		if (time != null) {
//			time = StringUtil.changeFormat("yyMMddHHmm", "yyyy-MM-dd HH:mm", time);
//		}
		this.time = time;
	}
	public String getbLongitude() {
		return bLongitude;
	}
	public void setbLongitude(String bLongitude) {
		this.bLongitude = bLongitude;
	}
	public String getbLatitude() {
		return bLatitude;
	}
	public void setbLatitude(String bLatitude) {
		this.bLatitude = bLatitude;
	}
	public String getbWatpolice() {
		return bWatpolice;
	}
	public void setbWatpolice(String bWatpolice) {
		this.bWatpolice = bWatpolice;
	}
	public String getbDoorpolice() {
		return bDoorpolice;
	}
	public void setbDoorpolice(String bDoorpolice) {
		this.bDoorpolice = bDoorpolice;
	}
	public String getbShift() {
		return bShift;
	}
	public void setbShift(String bShift) {
		this.bShift = bShift;
	}
	public String getbHatch() {
		return bHatch;
	}
	public void setbHatch(String bHatch) {
		this.bHatch = bHatch;
	}
	public String getbBearing() {
		return bBearing;
	}
	public void setbBearing(String bBearing) {
		this.bBearing = bBearing;
	}
	public String getbVoltage() {
		return bVoltage;
	}
	public void setbVoltage(String bVoltage) {
		this.bVoltage = bVoltage;
	}
	public String getbRidlight() {
		return bRidlight;
	}
	public void setbRidlight(String bRidlight) {
		this.bRidlight = bRidlight;
	}
	public String getbFree() {
		return bFree;
	}
	public void setbFree(String bFree) {
		this.bFree = bFree;
	}
	public String getwAirpre() {
		return wAirpre;
	}
	public void setwAirpre(String wAirpre) {
		this.wAirpre = wAirpre;
	}
	public String getwAirtemp() {
		return wAirtemp;
	}
	public void setwAirtemp(String wAirtemp) {
		this.wAirtemp = wAirtemp;
	}
	public String getwOppohumi() {
		return wOppohumi;
	}
	public void setwOppohumi(String wOppohumi) {
		this.wOppohumi = wOppohumi;
	}
	public String getWqWattemp() {
		return wqWattemp;
	}
	public void setWqWattemp(String wqWattemp) {
		this.wqWattemp = wqWattemp;
	}
	public String getWqSalinity() {
		return wqSalinity;
	}
	public void setWqSalinity(String wqSalinity) {
		this.wqSalinity = wqSalinity;
	}
	public String getWqConductivity() {
		return wqConductivity;
	}
	public void setWqConductivity(String wqConductivity) {
		this.wqConductivity = wqConductivity;
	}
	public String getcSpeed1() {
		return cSpeed1;
	}
	public void setcSpeed1(String cSpeed1) {
		this.cSpeed1 = cSpeed1;
	}
	public String getwHighMax() {
		return wHighMax;
	}
	public void setwHighMax(String wHighMax) {
		this.wHighMax = wHighMax;
	}
	public String getwHighTenth() {
		return wHighTenth;
	}
	public void setwHighTenth(String wHighTenth) {
		this.wHighTenth = wHighTenth;
	}
	public String getwHighAverage() {
		return wHighAverage;
	}
	public void setwHighAverage(String wHighAverage) {
		this.wHighAverage = wHighAverage;
	}
	public String getwHighEffective() {
		return wHighEffective;
	}
	public void setwHighEffective(String wHighEffective) {
		this.wHighEffective = wHighEffective;
	}
	public String getwCycleMax() {
		return wCycleMax;
	}
	public void setwCycleMax(String wCycleMax) {
		this.wCycleMax = wCycleMax;
	}
	public String getwCycleTenth() {
		return wCycleTenth;
	}
	public void setwCycleTenth(String wCycleTenth) {
		this.wCycleTenth = wCycleTenth;
	}
	public String getwCycleAverage() {
		return wCycleAverage;
	}
	public void setwCycleAverage(String wCycleAverage) {
		this.wCycleAverage = wCycleAverage;
	}
	public String getwCycleEffective() {
		return wCycleEffective;
	}
	public void setwCycleEffective(String wCycleEffective) {
		this.wCycleEffective = wCycleEffective;
	}
	public String getwTo() {
		return wTo;
	}
	public void setwTo(String wTo) {
		this.wTo = wTo;
	}
	public String getWindSpeedMax() {
		return windSpeedMax;
	}
	public void setWindSpeedMax(String windSpeedMax) {
		this.windSpeedMax = windSpeedMax;
	}
	public String getWindSpeedMaxto() {
		return windSpeedMaxto;
	}
	public void setWindSpeedMaxto(String windSpeedMaxto) {
		this.windSpeedMaxto = windSpeedMaxto;
	}
	public String getWindSpeedJi() {
		return windSpeedJi;
	}
	public void setWindSpeedJi(String windSpeedJi) {
		this.windSpeedJi = windSpeedJi;
	}
	public String getWindSpeedJito() {
		return windSpeedJito;
	}
	public void setWindSpeedJito(String windSpeedJito) {
		this.windSpeedJito = windSpeedJito;
	}
	public String getWindSpeedTen() {
		return windSpeedTen;
	}
	public void setWindSpeedTen(String windSpeedTen) {
		this.windSpeedTen = windSpeedTen;
	}
	public String getWindSpeedTento() {
		return windSpeedTento;
	}
	public void setWindSpeedTento(String windSpeedTento) {
		this.windSpeedTento = windSpeedTento;
	}
	public String getWindSpeedInstant() {
		return windSpeedInstant;
	}
	public void setWindSpeedInstant(String windSpeedInstant) {
		this.windSpeedInstant = windSpeedInstant;
	}
	public String getWindToInstant() {
		return windToInstant;
	}
	public void setWindToInstant(String windToInstant) {
		this.windToInstant = windToInstant;
	}
	
	
	public String getbBuoyid() {
		return bBuoyid;
	}
	public void setbBuoyid(String bBuoyid) {
		this.bBuoyid = bBuoyid;
	}
	
	
	public String getcTo1() {
		return cTo1;
	}
	public void setcTo1(String cTo1) {
		this.cTo1 = cTo1;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	public String getoLongitude() {
		return oLongitude;
	}
	public void setoLongitude(String oLongitude) {
		this.oLongitude = oLongitude;
	}
	public String getoLatitude() {
		return oLatitude;
	}
	public void setoLatitude(String oLatitude) {
		this.oLatitude = oLatitude;
	}
	
	public String getMoveDistance() {
		return moveDistance;
	}
	public void setMoveDistance(String moveDistance) {
		this.moveDistance = moveDistance;
	}
	@Override
	public String toString() {
		return "StatisticsVo [station=" + station + ", bBuoyid=" + bBuoyid + ", time=" + time + ", bLongitude="
				+ bLongitude + ", bLatitude=" + bLatitude + ", oLongitude=" + oLongitude + ", oLatitude=" + oLatitude
				+ ", bWatpolice=" + bWatpolice + ", bDoorpolice=" + bDoorpolice + ", bShift=" + bShift + ", bHatch="
				+ bHatch + ", bBearing=" + bBearing + ", bVoltage=" + bVoltage + ", bRidlight=" + bRidlight + ", bFree="
				+ bFree + ", wAirpre=" + wAirpre + ", wAirtemp=" + wAirtemp + ", wOppohumi=" + wOppohumi
				+ ", wqWattemp=" + wqWattemp + ", wqSalinity=" + wqSalinity + ", wqConductivity=" + wqConductivity
				+ ", cSpeed1=" + cSpeed1 + ", cTo1=" + cTo1 + ", wHighMax=" + wHighMax + ", wHighTenth=" + wHighTenth
				+ ", wHighAverage=" + wHighAverage + ", wHighEffective=" + wHighEffective + ", wCycleMax=" + wCycleMax
				+ ", wCycleTenth=" + wCycleTenth + ", wCycleAverage=" + wCycleAverage + ", wCycleEffective="
				+ wCycleEffective + ", wTo=" + wTo + ", windSpeedMax=" + windSpeedMax + ", windSpeedMaxto="
				+ windSpeedMaxto + ", windSpeedJi=" + windSpeedJi + ", windSpeedJito=" + windSpeedJito
				+ ", windSpeedTen=" + windSpeedTen + ", windSpeedTento=" + windSpeedTento + ", windSpeedInstant="
				+ windSpeedInstant + ", windToInstant=" + windToInstant + ", isFault=" + isFault + "]";
	}
    
}
